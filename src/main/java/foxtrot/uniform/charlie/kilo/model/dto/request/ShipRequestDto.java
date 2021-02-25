package foxtrot.uniform.charlie.kilo.model.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ShipRequestDto {
    @NotNull
    private String title;
    @Positive
    private int capacity;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ShipRequestDto{" + "title='" + title + '\''
                + ", capacity=" + capacity
                + ", description='" + description + '\'' + '}';
    }
}
