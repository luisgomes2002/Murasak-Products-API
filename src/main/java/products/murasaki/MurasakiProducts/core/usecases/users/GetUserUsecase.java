package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;

import java.util.Optional;

public interface GetUserUsecase {

    public User execute(Long id);
}
