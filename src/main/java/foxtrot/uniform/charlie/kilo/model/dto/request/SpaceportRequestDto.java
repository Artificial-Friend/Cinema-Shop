package foxtrot.uniform.charlie.kilo.model.dto.request;

import javax.validation.constraints.PositiveOrZero;

public class SpaceportRequestDto {
    @PositiveOrZero
    private int hangarsQuantity;
    private String description;

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
        return "CinemaHallDto{" + ", hangarsQuantity=" + hangarsQuantity
                + ", description='" + description + '\'' + '}';
    }
}
