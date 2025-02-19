package products.murasaki.MurasakiProducts.core.usecases;

import products.murasaki.MurasakiProducts.core.entities.User;

import java.util.List;

public interface GetUsersUsecase {

    public List<User> execute();
}
