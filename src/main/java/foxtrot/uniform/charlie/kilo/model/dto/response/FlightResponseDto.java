package foxtrot.uniform.charlie.kilo.model.dto.response;

public class FlightResponseDto {
    private Long id;
    private Long shipId;
    private String shipName;
    private int shipCapacity;
    private String shipIdentifier;
    private Long flightId;
    private String flightDescription;
    private String flightDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipIdentifier() {
        return shipIdentifier;
    }

    public void setShipIdentifier(String shipIdentifier) {
        this.shipIdentifier = shipIdentifier;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightDescription() {
        return flightDescription;
    }

    public void setFlightDescription(String flightDescription) {
        this.flightDescription = flightDescription;
    }

    public String getFlightDateTime() {
        return flightDateTime;
    }

    public void setFlightDateTime(String flightDateTime) {
        this.flightDateTime = flightDateTime;
    }

    @Override
    public String toString() {
        return "FlightResponseDto{" + "id=" + id
                + ", shipId=" + shipId
                + ", shipName='" + shipName + '\''
                + ", shipCapacity=" + shipCapacity
                + ", shipIdentifier='" + shipIdentifier + '\''
                + ", flightId=" + flightId
                + ", flightDescription='" + flightDescription + '\''
                + ", flightDateTime='" + flightDateTime + '\'' + '}';
    }
}
