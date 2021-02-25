package foxtrot.uniform.charlie.kilo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cinema_halls")
public class Spaceport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int hangarsQuantity;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHangarsQuantity() {
        return hangarsQuantity;
    }

    public void setHangarsQuantity(int capacity) {
        this.hangarsQuantity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CinemaHall{" + "id=" + id
                + ", hangarsQuantity=" + hangarsQuantity
                + ", description='" + description + '\'' + '}';
    }
}
