package per.xck.SeatOccupying.model;

import javax.persistence.*;

@Entity
@Table(name = "t_seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Boolean occupied;

    @Column
    private Integer seatUser;

    public Integer getSeatUser() {
        return seatUser;
    }

    public void setSeatUser(Integer seatUser) {
        this.seatUser = seatUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
