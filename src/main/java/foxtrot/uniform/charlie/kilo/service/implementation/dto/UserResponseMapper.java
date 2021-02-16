package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.model.dto.UserResponseDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }

    @Override
    public User fromDto(UserResponseDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setId(dto.getId());
        return user;
    }
}
