package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.ShoppingCart;
import foxtrot.uniform.charlie.kilo.model.dto.response.ShoppingCartResponseDto;
import foxtrot.uniform.charlie.kilo.service.FlightService;
import foxtrot.uniform.charlie.kilo.service.ShoppingCartService;
import foxtrot.uniform.charlie.kilo.service.UserService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final FlightService flightService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MapperToDto<ShoppingCartResponseDto, ShoppingCart> responseMapper;

    @Autowired
    public ShoppingCartController(FlightService flightService,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MapperToDto<ShoppingCartResponseDto,
                                          ShoppingCart> responseMapper) {
        this.flightService = flightService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/flights")
    public void addFlightToShoppingCart(@RequestParam Long userId,
                                        @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(flightService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return responseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
