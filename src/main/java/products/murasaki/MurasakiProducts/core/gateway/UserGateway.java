package products.murasaki.MurasakiProducts.core.gateway;

import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserGateway {

    User createUser(User user);
    List<User> getUsers();
    User getUserById(Long id);
    Optional<User> updateUser(Long id, User user);
    void deleteUser(Long id);

    boolean userAlreadyCreated(String email);
    boolean userIdExists(Long id);
}
