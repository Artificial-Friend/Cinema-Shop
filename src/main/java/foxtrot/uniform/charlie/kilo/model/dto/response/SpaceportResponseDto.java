package foxtrot.uniform.charlie.kilo.model.dto.response;

public class SpaceportResponseDto {
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

    public void setHangarsQuantity(int hangarsQuantity) {
        this.hangarsQuantity = hangarsQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CinemaHallDto{" + "id=" + id
                + ", hangarsQuantity=" + hangarsQuantity
                + ", description='" + description + '\'' + '}';
    }
}
