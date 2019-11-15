package per.xck.SeatOccupying.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import per.xck.SeatOccupying.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value = "select * from t_user where wx_open_id = ?1",nativeQuery = true)
    User QueryOneByWxOpenId(@Param("wxOpenId") String wxOpenId);
}
