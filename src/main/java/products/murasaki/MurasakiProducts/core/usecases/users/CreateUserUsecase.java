package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;

public interface CreateUserUsecase {

    public User execute(User user);
}
