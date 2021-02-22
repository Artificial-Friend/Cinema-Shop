package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.exception.AuthenticationException;
import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.service.AuthenticationService;
import foxtrot.uniform.charlie.kilo.service.RoleService;
import foxtrot.uniform.charlie.kilo.service.ShoppingCartService;
import foxtrot.uniform.charlie.kilo.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        Optional<User> userByEmail = userService.findByEmail(email);
        if (userByEmail.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setRoles(List.of(roleService.getRoleByName("USER")));
            userService.add(user);
            shoppingCartService.registerNewShoppingCart(user);
            return user;
        }
        throw new AuthenticationException("ERROR: Unable to register user with email " + email);
    }
}
