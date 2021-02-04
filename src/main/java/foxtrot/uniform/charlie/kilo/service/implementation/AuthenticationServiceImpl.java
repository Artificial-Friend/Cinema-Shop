package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.exception.AuthenticationException;
import foxtrot.uniform.charlie.kilo.lib.Inject;
import foxtrot.uniform.charlie.kilo.lib.Service;
import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.service.AuthenticationService;
import foxtrot.uniform.charlie.kilo.service.ShoppingCartService;
import foxtrot.uniform.charlie.kilo.service.UserService;
import foxtrot.uniform.charlie.kilo.util.HashUtil;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> userByLogin = userService.findByEmail(email);
        if (userByLogin.isPresent() && userByLogin.get().getPassword().equals(HashUtil.hashPassword(
                password, userByLogin.get().getSalt()))) {
            return userByLogin.get();
        }
        throw new AuthenticationException("Unable to login: user not found or password is invalid");
    }

    @Override
    public User register(String email, String password) {
        Optional<User> userByEmail = userService.findByEmail(email);
        if (userByEmail.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setSalt(HashUtil.getSalt());
            user.setPassword(HashUtil.hashPassword(password, user.getSalt()));
            userService.add(user);
            shoppingCartService.registerNewShoppingCart(user);
            return user;
        }
        throw new AuthenticationException("ERROR: Unable to register user with email " + email);
    }
}
