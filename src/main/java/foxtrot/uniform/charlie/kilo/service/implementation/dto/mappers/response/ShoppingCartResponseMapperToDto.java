package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response;

import foxtrot.uniform.charlie.kilo.model.ShoppingCart;
import foxtrot.uniform.charlie.kilo.model.Ticket;
import foxtrot.uniform.charlie.kilo.model.dto.response.ShoppingCartResponseDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapperToDto implements
        MapperToDto<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setId(shoppingCart.getId());
        dto.setTicketIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
