package foxtrot.uniform.charlie.kilo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;
    @ManyToOne
    @JoinColumn(name = "spaceport_id")
    private Spaceport spaceport;
    @Column(name = "flight_datetime")
    private LocalDateTime flightDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Spaceport getSpaceport() {
        return spaceport;
    }

    public void setSpaceport(Spaceport spaceport) {
        this.spaceport = spaceport;
    }

    public LocalDateTime getFlightDateTime() {
        return flightDateTime;
    }

    public void setFlightDateTime(LocalDateTime showTime) {
        this.flightDateTime = showTime;
    }

    @Override
    public String toString() {
        return "MovieSession{" + "id=" + id
                + ", ship=" + ship
                + ", spaceport=" + spaceport
                + ", flightDateTime=" + flightDateTime + '}';
    }
}
