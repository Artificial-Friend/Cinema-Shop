package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
