package per.xck.SeatOccupying.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import per.xck.SeatOccupying.Repository.SeatRepository;
import per.xck.SeatOccupying.Repository.UserRepository;
import per.xck.SeatOccupying.Util.utils;
import per.xck.SeatOccupying.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
//    private static final String APPID="wx8b3fbe7470d433f1";
//    private static final String APPSECRET="41c89225d27f1920a963336ce2735e67";

    @Autowired
    UserRepository userRepository;
    @Autowired
    SeatRepository seatRepository;

//    @RequestMapping("/")
//    public String success(@RequestParam("code") String code,
//                          HttpSession session){
//        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+APPSECRET+"&code="+code+"&grant_type=authorization_code";
//        String result = utils.get(url);
//
//        Map<String, Object> map = new HashMap<>();
//        try{
//            Gson gson = new Gson();
//            map = gson.fromJson(result,new TypeToken<Map<String,Object>>(){
//            }.getType());
//        }catch (JsonSyntaxException e){
//        }
//        String openId = (String) map.get("openid");
//        if(session.getAttribute("openId")==null){
//            session.setAttribute("openId",openId);
//        }
//        System.out.println(session.getAttribute("openId"));//openId为用户唯一Id
//
//        try{
//            User user = userRepository.QueryOneByWxOpenId(openId);
//        }catch (NullPointerException e){
//            System.out.println("The first time user sign up");
//            return "login";
//        };
//        System.out.println("The user has sign upped yet");
//        return "redirect:/user/login";
//    }

    @RequestMapping("/")
    public String index(HttpSession session,
                        HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        try{
            User user = (User) session.getAttribute("user");
            if(user.getId() == null){
                System.out.println("first login");
                return "login";
            }
            System.out.println(user);
        }catch (NullPointerException e){
            System.out.println("first login");
            return "login";
        }

        return "success";
    }

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        User user = new User();
        user.setName(username);
        user.setPassword(utils.MD5encode(username+password));
        user.setWxOpenId((String) session.getAttribute(""));
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());

        session.setAttribute("user",user);
//        cookie.;

        userRepository.save(user);
        return "success";
    }
}
