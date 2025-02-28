package products.murasaki.MurasakiProducts.infrastructure.geteway;

import org.springframework.stereotype.Component;
import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.infrastructure.mapper.UserEntityMapper;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserEntity;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        UserEntity newUSer = userRepository.save(entity);
        return mapper.toDomain(newUSer);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public boolean userAlreadyCreated(String email) {
        return userRepository.findAll().stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

    @Override
    public Optional<User> updateUser(Long id, User user) {
        Optional<UserEntity> entity = userRepository.findById(id);

        if(entity.isPresent()){
            UserEntity updatedUser = entity.get();
            updatedUser.setName(user.name());
            updatedUser.setEmail(user.email());
            updatedUser.setPassword(user.password());
            updatedUser.setCreatedAt(entity.get().getCreatedAt());
            updatedUser.setUpdatedAt(LocalDateTime.now());
            updatedUser.setUserType(user.userType());

            userRepository.save(updatedUser);
            return Optional.of(mapper.toDomain(updatedUser));
        }

        return Optional.empty();
    }

    @Override
    public boolean userIdExists(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
