package foxtrot.uniform.charlie.kilo.model.dto.response;

public class ShipResponseDto {
    private Long id;
    private String name;
    private int capacity;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "ShipResponseDto{" + "id=" + id
                + ", name='" + name + '\''
                + ", capacity=" + capacity
                + ", identifier='" + identifier + '\'' + '}';
    }
}
