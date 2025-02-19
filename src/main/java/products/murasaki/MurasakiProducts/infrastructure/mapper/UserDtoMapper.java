package products.murasaki.MurasakiProducts.infrastructure.mapper;

import org.springframework.stereotype.Component;
import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.infrastructure.dtos.UserDto;

@Component
public class UserDtoMapper {

    public UserDto toDto(User user){
        return new UserDto(
                user.id(),
                user.name(),
                user.email(),
                user.password(),
                user.created_at(),
                user.updated_at()
        );
    }

    public User toDomain(UserDto userDto){
        return new User(
                userDto.id(),
                userDto.name(),
                userDto.email(),
                userDto.password(),
                userDto.created_at(),
                userDto.updated_at()
        );
    }
}
