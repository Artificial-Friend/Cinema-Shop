package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.dto.UserRequestDto;
import foxtrot.uniform.charlie.kilo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userDto) {
        authenticationService.register(userDto.getEmail(), userDto.getPassword());
    }
}
