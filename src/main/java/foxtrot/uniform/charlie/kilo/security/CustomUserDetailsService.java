package foxtrot.uniform.charlie.kilo.security;

import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.service.UserService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.JwtUserMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    private final JwtUserMapper jwtUserMapper;

    @Autowired
    public CustomUserDetailsService(UserService userService, JwtUserMapper jwtUserMapper) {
        this.userService = userService;
        this.jwtUserMapper = jwtUserMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User '" + email + "' not found"));
        UserBuilder userBuilder
                = org.springframework.security.core.userdetails.User.withUsername(email);
        userBuilder.password(user.getPassword());
        userBuilder.authorities(user.getRoles());
        //return userBuilder.build();
        return jwtUserMapper.mapUserToJwt(user);
    }
}
