package products.murasaki.MurasakiProducts.core.usecases;

import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;

import java.util.List;

public class GetUsersUsecaseImpl implements GetUsersUsecase {

    private final UserGateway userGateway;

    public GetUsersUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
        return userGateway.getUsers();
    }
}
