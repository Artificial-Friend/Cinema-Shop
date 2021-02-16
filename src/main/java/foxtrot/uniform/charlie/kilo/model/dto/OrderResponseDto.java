package foxtrot.uniform.charlie.kilo.model.dto;

import java.util.Arrays;

public class OrderResponseDto {
    private Long id;
    private Long[] ticketIds;
    private String date;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long[] getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(Long[] ticketIds) {
        this.ticketIds = ticketIds;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{" + "id=" + id
                + ", tickets=" + Arrays.toString(ticketIds)
                + ", date='" + date + '\''
                + ", userId=" + userId + '}';
    }
}
