package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;

import java.util.Optional;

public interface UpdateUserUsecase {

    public Optional<User> execute(Long id, User user);
}
