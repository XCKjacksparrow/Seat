package per.xck.SeatOccupying;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.xck.SeatOccupying.Repository.SeatRepository;
import per.xck.SeatOccupying.model.Seat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeatOccupyingApplicationTests {

    @Autowired
    SeatRepository seatRepository;

    @Test
    public void contextLoads() {
//        System.out.println(seatRepository.queryAllOccupied());


//        Integer seatNum = 20;
//        Seat seat = new Seat();
//        seat.setId(seatRepository.findOne(seatNum).getId());
//        seat.setOccupied(true);
//        seatRepository.save(seat);


    }


}
