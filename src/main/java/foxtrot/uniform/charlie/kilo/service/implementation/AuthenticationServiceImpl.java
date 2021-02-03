package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.UserDao;
import foxtrot.uniform.charlie.kilo.exception.AuthenticationException;
import foxtrot.uniform.charlie.kilo.lib.Inject;
import foxtrot.uniform.charlie.kilo.lib.Service;
import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.service.AuthenticationService;
import foxtrot.uniform.charlie.kilo.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserDao userDao;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> userByLogin = userDao.getByLogin(email);
        if (userByLogin.isPresent() && userByLogin.get().getPassword().equals(HashUtil.hashPassword(
                password, userByLogin.get().getSalt()))) {
            return userByLogin.get();
        }
        throw new AuthenticationException("Unable to login: user not found or password is invalid");
    }

    @Override
    public User register(String email, String password) {
        Optional<User> userByEmail = userDao.getByLogin(email);
        if (userByEmail.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setSalt(HashUtil.getSalt());
            user.setPassword(HashUtil.hashPassword(password, user.getSalt()));
            return userDao.add(user);
        }
        throw new AuthenticationException("ERROR: Unable to register user with email " + email);
    }
}
