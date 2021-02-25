package foxtrot.uniform.charlie.kilo.model.dto.request;

import javax.validation.constraints.PositiveOrZero;

public class FlightRequestDto {
    @PositiveOrZero
    private Long shipId;
    @PositiveOrZero
    private Long spaceportId;
    private String flightDateTime;

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getSpaceportId() {
        return spaceportId;
    }

    public void setSpaceportId(Long spaceportId) {
        this.spaceportId = spaceportId;
    }

    public String getFlightDateTime() {
        return flightDateTime;
    }

    public void setFlightDateTime(String flightDateTime) {
        this.flightDateTime = flightDateTime;
    }

    @Override
    public String toString() {
        return "MovieSessionResponseDto{" + ", shipId=" + shipId
                + ", spaceportId=" + spaceportId
                + ", flightDateTime=" + flightDateTime + '}';
    }
}
