package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.Order;
import foxtrot.uniform.charlie.kilo.model.Ticket;
import foxtrot.uniform.charlie.kilo.model.dto.OrderResponseDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import foxtrot.uniform.charlie.kilo.service.UserService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements Mapper<OrderResponseDto, Order> {
    private final UserService userService;

    public OrderResponseMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setDate(order.getOrderDate().toString());
        dto.setTicketIds(order.getTickets().stream()
                .map(Ticket::getId)
                .toArray(Long[]::new));
        dto.setUserId(order.getUser().getId());
        return dto;
    }

    @Override
    public Order fromDto(OrderResponseDto dto) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.parse(dto.getDate()));
        order.setUser(userService.get(dto.getUserId()).get());
        order.setTickets(Arrays.stream(dto.getTicketIds())
                .map((e) -> {
                    Ticket ticket = new Ticket();
                    ticket.setId(e);
                    return ticket;
                })
                .collect(Collectors.toList()));
        order.setId(dto.getId());
        return order;
    }
}
