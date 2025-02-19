package products.murasaki.MurasakiProducts.infrastructure.mapper;

import org.springframework.stereotype.Component;
import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserEntity;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(
                user.id(),
                user.name(),
                user.email(),
                user.password(),
                user.created_at(),
                user.updated_at()
        );

    }

    public User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCreated_at(),
                userEntity.getUpdated_at()
        );
    }

}
