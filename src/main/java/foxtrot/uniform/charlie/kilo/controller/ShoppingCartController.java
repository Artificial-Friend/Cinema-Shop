package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.dto.ShoppingCartResponseDto;
import foxtrot.uniform.charlie.kilo.service.MovieSessionService;
import foxtrot.uniform.charlie.kilo.service.ShoppingCartService;
import foxtrot.uniform.charlie.kilo.service.UserService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.ShoppingCartResponseMapperToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartResponseMapperToDto responseMapper;

    @Autowired
    public ShoppingCartController(MovieSessionService movieSessionService,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartResponseMapperToDto responseMapper) {
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSessionToShoppingCart(@RequestParam Long userId,
                                              @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto get(@RequestParam Long userId) {
        return responseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
