package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.infrastructure.exception.IdNotFoundException;

import java.util.Optional;

public class GetUserUsecaseImpl implements GetUserUsecase{

    private final UserGateway userGateway;

    public GetUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(Long id) {
        if(userGateway.userIdExists(id)){
            return userGateway.getUserById(id);
        }
        throw new IdNotFoundException("O ID fornecido não foi encontrado.");
    }
}
