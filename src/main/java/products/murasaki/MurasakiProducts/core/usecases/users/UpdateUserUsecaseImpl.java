package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.infrastructure.exception.IdNotFoundException;

import java.util.Optional;

public class UpdateUserUsecaseImpl implements UpdateUserUsecase{

    private final UserGateway userGateway;

    public UpdateUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public Optional<User> execute(Long id, User user) {
        if(userGateway.userIdExists(id)){
            return userGateway.updateUser(id, user);
        }
        throw new IdNotFoundException("O ID fornecido não foi encontrado.");
    }
}
