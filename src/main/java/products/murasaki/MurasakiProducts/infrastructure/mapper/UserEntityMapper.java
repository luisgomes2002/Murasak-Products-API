package products.murasaki.MurasakiProducts.infrastructure.mapper;

import org.springframework.stereotype.Component;
import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserEntity;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(
                user.name(),
                user.email(),
                user.password(),
                user.createdAt(),
                user.updatedAt(),
                user.userType()
        );

    }

    public User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt(),
                userEntity.getUserType()
        );
    }

}
