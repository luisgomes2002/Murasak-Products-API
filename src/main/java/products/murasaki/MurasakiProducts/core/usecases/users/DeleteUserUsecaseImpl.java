package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.infrastructure.exception.IdNotFoundException;

public class DeleteUserUsecaseImpl implements DeleteUserUsecase{

    private final UserGateway userGateway;

    public DeleteUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public String execute(Long id) {
        if(userGateway.userIdExists(id)){
            userGateway.deleteUser(id);
            return "Usuário deletado com sucesso.";
        }
        throw new IdNotFoundException("O ID fornecido não foi encontrado.");
    }
}
