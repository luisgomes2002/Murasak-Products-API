package products.murasaki.MurasakiProducts.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import products.murasaki.MurasakiProducts.core.gateway.UserGateway;
import products.murasaki.MurasakiProducts.core.usecases.users.*;

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

    @Bean
    public GetUserUsecase getUserUsecase(UserGateway userGateway) {return new GetUserUsecaseImpl(userGateway);}

    @Bean
    public UpdateUserUsecase updateUserUsecase(UserGateway userGateway) {return new UpdateUserUsecaseImpl(userGateway);}

    @Bean
    public DeleteUserUsecase deleteUserUsecase(UserGateway userGateway) {return new DeleteUserUsecaseImpl(userGateway);}



}
