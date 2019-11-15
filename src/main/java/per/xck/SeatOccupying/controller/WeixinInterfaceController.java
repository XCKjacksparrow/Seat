package per.xck.SeatOccupying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.xck.SeatOccupying.Util.WX_Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class WeixinInterfaceController {
    @ResponseBody
    @RequestMapping("/wx")
    public void weixininter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //微信获取解析信息
        String str = WX_Util.check_Url(request);
        PrintWriter out = response.getWriter();
        //输出
        out.print(str);
        //刷新
        out.flush();
        //关闭流
        out.close();
    }
}
