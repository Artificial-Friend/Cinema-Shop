package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.model.dto.UserRequestDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;

public class UserRequestMapper implements Mapper<UserRequestDto, User> {
    @Override
    public UserRequestDto toDto(User user) {
        UserRequestDto dto = new UserRequestDto();
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        return dto;
    }

    @Override
    public User fromDto(UserRequestDto dto) {
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }
}
