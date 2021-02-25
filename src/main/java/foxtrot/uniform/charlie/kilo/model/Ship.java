package foxtrot.uniform.charlie.kilo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ships")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;
    @Column(unique = true)
    private String identifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String description) {
        this.identifier = description;
    }

    @Override
    public String toString() {
        return "Ship{" + "id=" + id
                + ", name='" + name + '\''
                + ", capacity=" + capacity
                + ", identifier='" + identifier + '\'' + '}';
    }
}
