package per.xck.SeatOccupying.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import per.xck.SeatOccupying.Repository.SeatRepository;
import per.xck.SeatOccupying.model.Seat;

@Controller
public class SeatController {

    @Autowired
    SeatRepository seatRepository;

    @RequestMapping("/selectSeats")         // 跳转显示座位页面
    public String select(){
        return "selectSeats";
    }

    @GetMapping("/getSeats")            // 查询座位信息
    @ResponseBody
    public String getSeats() {
        return seatRepository.queryAllOccupied().toString();
    }

    @PostMapping("/submit")
    @ResponseBody
    public String submit(@RequestParam(value = "current") String current    // 选中的座位号
                         ) {
//        System.out.println(current);
        Integer seatNum = Integer.parseInt(current);
        Seat seat = new Seat();
        seat.setId(seatRepository.findOne(seatNum).getId());
        seat.setOccupied(true);
        seatRepository.save(seat);
        return "success";
    }
}
