package products.murasaki.MurasakiProducts.infrastructure.geteway;

import org.springframework.stereotype.Component;
import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.infrastructure.mapper.UserEntityMapper;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserEntity;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserRepository;

import java.util.List;

@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper mapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity newUSer = userRepository.save(entity);
        return mapper.toDomain(newUSer);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(mapper::toDomain).toList();
    }


}
