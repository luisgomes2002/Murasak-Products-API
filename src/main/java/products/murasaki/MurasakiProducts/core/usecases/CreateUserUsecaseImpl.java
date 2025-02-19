package products.murasaki.MurasakiProducts.core.usecases;

import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;

public class CreateUserUsecaseImpl implements CreateUserUsecase {

    private final UserGateway userGateway;

    public CreateUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        return userGateway.createUser(user);
    }
}
