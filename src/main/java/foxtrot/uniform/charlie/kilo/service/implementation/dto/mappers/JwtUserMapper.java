package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers;

import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.security.jwt.JwtUser;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class JwtUserMapper {
    public JwtUserMapper() {
    }

    public JwtUser mapUserToJwt(User user) {
        return new JwtUser(user.getEmail(), user.getPassword(), new ArrayList<>(user.getRoles()));
    }
}
