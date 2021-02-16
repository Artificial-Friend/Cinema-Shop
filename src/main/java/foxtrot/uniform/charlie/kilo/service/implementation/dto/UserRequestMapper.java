package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.model.dto.UserRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements MapperFromDto<UserRequestDto, User> {
    @Override
    public User fromDto(UserRequestDto dto) {
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }
}
