package products.murasaki.MurasakiProducts.infrastructure.presentation;

import org.springframework.web.bind.annotation.*;
import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.usecases.CreateUserUsecase;
import products.murasaki.MurasakiProducts.core.usecases.GetUsersUsecase;
import products.murasaki.MurasakiProducts.infrastructure.dtos.UserDto;
import products.murasaki.MurasakiProducts.infrastructure.mapper.UserDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user/")
public class UserController {

    private final CreateUserUsecase createUserUseCase;
    private final GetUsersUsecase getUsersUseCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserUsecase createUserUseCase, GetUsersUsecase getUsersUseCase, UserDtoMapper userDtoMapper) {
        this.createUserUseCase = createUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("create")
    public UserDto createUser(@RequestBody UserDto userDTO){
        User newUser = createUserUseCase.execute(userDtoMapper.toDomain(userDTO));
        return userDtoMapper.toDto(newUser);
    }

    @GetMapping("/")
    public List<UserDto> getUsers(){
        return getUsersUseCase.execute().stream().map(userDtoMapper::toDto).collect(Collectors.toList());
    }
}
