package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.ShoppingCart;
import foxtrot.uniform.charlie.kilo.model.Ticket;
import foxtrot.uniform.charlie.kilo.model.dto.ShoppingCartResponseDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import foxtrot.uniform.charlie.kilo.service.UserService;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements Mapper<ShoppingCartResponseDto, ShoppingCart> {
    private final UserService userService;

    public ShoppingCartResponseMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(shoppingCart.getId());
        dto.setTicketIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .toArray(Long[]::new));
        dto.setUserId(shoppingCart.getUser().getId());
        return dto;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartResponseDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.get(dto.getUserId()).get());
        shoppingCart.setTickets(Arrays.stream(dto.getTicketIds())
                .map((e) -> {
                    Ticket ticket = new Ticket();
                    ticket.setId(e);
                    return ticket;
                })
                .collect(Collectors.toList()));
        shoppingCart.setId(dto.getId());
        return shoppingCart;
    }
}
