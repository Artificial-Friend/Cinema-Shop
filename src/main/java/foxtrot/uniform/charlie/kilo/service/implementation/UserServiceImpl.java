package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.UserDao;
import foxtrot.uniform.charlie.kilo.lib.Inject;
import foxtrot.uniform.charlie.kilo.lib.Service;
import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.service.UserService;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        userDao.add(user);
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.getByLogin(email);
    }
}
