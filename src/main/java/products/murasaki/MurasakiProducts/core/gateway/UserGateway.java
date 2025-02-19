package products.murasaki.MurasakiProducts.core.gateway;

import products.murasaki.MurasakiProducts.core.entities.User;

import java.util.List;

public interface UserGateway {

    User createUser(User user);
    List<User> getUsers();
}
