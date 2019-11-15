package per.xck.SeatOccupying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test0")
    public String test0(){
        return "testCamara/qr-index.html";
    }


    @RequestMapping("/test1")
    public String test1(){
        return "testCamara/br-success-1.html";
    }


    @RequestMapping("/test2")
    public String test2(){
        return "testCamara/br-success-2.html";
    }
}
