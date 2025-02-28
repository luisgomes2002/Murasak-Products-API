package products.murasaki.MurasakiProducts.core.usecases.users;

import products.murasaki.MurasakiProducts.core.entities.User;

public interface DeleteUserUsecase {

    public String execute(Long id);
}
