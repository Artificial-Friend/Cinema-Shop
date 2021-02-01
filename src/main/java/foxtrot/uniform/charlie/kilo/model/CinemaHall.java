package foxtrot.uniform.charlie.kilo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cinemaHall")
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int capacity;
    private String description;

    public Long getId() {
        return id;
    }

    public CinemaHall setId(Long id) {
        this.id = id;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public CinemaHall setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CinemaHall setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "CinemaHall{" + "id=" + id
                + ", capacity=" + capacity
                + ", description='" + description + '\'' + '}';
    }
}
