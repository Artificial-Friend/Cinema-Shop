package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.model.dto.request.UserLoginDto;
import foxtrot.uniform.charlie.kilo.model.dto.request.UserRegistrationDto;
import foxtrot.uniform.charlie.kilo.security.jwt.JwtTokenProvider;
import foxtrot.uniform.charlie.kilo.service.AuthenticationService;
import foxtrot.uniform.charlie.kilo.service.UserService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    AuthenticationManager authenticationManager,
                                    JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRegistrationDto userDto) {
        authenticationService.register(userDto.getEmail(), userDto.getPassword());
    }

    @PostMapping("/login")
    public void login(@RequestBody @Valid UserLoginDto userDto) {
        try {
            String username = userDto.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    userDto.getPassword()));
            User user = userService.findByEmail(username).orElseThrow(() ->
                    new UsernameNotFoundException("Can't find " + username));

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            //return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException("NOT OK");
        }
    }
}
