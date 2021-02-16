package foxtrot.uniform.charlie.kilo.model.dto;

import java.util.Arrays;

public class ShoppingCartResponseDto {
    private Long id;
    private Long[] ticketIds;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCartResponseDto{" + "id=" + id
                + ", ticketIds=" + Arrays.toString(ticketIds)
                + ", userId=" + userId + '}';
    }
}
