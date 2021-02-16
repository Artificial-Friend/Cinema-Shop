package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> getByLogin(String login);

    Optional<User> get(Long id);
}
