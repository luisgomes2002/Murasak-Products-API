package products.murasaki.MurasakiProducts.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.core.usecases.CreateUserUsecase;
import products.murasaki.MurasakiProducts.core.usecases.CreateUserUsecaseImpl;
import products.murasaki.MurasakiProducts.core.usecases.GetUsersUsecase;
import products.murasaki.MurasakiProducts.core.usecases.GetUsersUsecaseImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateUserUsecase createUserUseCase(UserGateway userGateway){
        return new CreateUserUsecaseImpl(userGateway);
    }

    @Bean
    public GetUsersUsecase getUsersUsecase(UserGateway userGateway){
        return new GetUsersUsecaseImpl(userGateway);
    }

}
