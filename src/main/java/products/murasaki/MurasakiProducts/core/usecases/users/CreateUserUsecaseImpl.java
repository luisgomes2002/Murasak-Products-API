package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.infrastructure.exception.DuplicateUserException;

public class CreateUserUsecaseImpl implements CreateUserUsecase {

    private final UserGateway userGateway;

    public CreateUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        if(userGateway.userAlreadyCreated(user.email())){
            throw new DuplicateUserException("Usuário com email: " + user.email() + " já existe.");
        }
        return userGateway.createUser(user);
    }
}
