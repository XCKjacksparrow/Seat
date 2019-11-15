package per.xck.SeatOccupying.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import per.xck.SeatOccupying.model.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {


    @Query(value = "SELECT occupied from t_seat limit 100",nativeQuery = true)
    List<Boolean> queryAllOccupied();

}
