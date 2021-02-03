package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.exception.AuthenticationException;
import foxtrot.uniform.charlie.kilo.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
