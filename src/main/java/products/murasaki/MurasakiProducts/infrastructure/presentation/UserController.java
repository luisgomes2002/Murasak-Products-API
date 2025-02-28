package products.murasaki.MurasakiProducts.infrastructure.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products.murasaki.MurasakiProducts.core.entities.User;
import products.murasaki.MurasakiProducts.core.usecases.users.*;
import products.murasaki.MurasakiProducts.infrastructure.dtos.UserDto;
import products.murasaki.MurasakiProducts.infrastructure.mapper.UserDtoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user/")
public class UserController {

    private final CreateUserUsecase createUserUseCase;
    private final GetUsersUsecase getUsersUseCase;
    private final GetUserUsecase getUserUsecase;
    private final UpdateUserUsecase updateUserUsecase;
    private final DeleteUserUsecase deleteUserUsecase;
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserUsecase createUserUseCase, GetUsersUsecase getUsersUseCase, UpdateUserUsecase updateUserUsecase, DeleteUserUsecase deleteUserUsecase, GetUserUsecase getUserUsecase, UserDtoMapper userDtoMapper) {
        this.createUserUseCase = createUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
        this.updateUserUsecase = updateUserUsecase;
        this.deleteUserUsecase = deleteUserUsecase;
        this.getUserUsecase = getUserUsecase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDTO){
        User newUser = createUserUseCase.execute(userDtoMapper.toDomain(userDTO));
        Map<String,Object> response = new HashMap<>();
        response.put("Message:", "Usuário criado com sucesso.");
        response.put("User data:", userDtoMapper.toDto(newUser));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public List<UserDto> getUsers(){
        return getUsersUseCase.execute().stream().map(userDtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
       User user = getUserUsecase.execute(id);
       return ResponseEntity.ok(userDtoMapper.toDto(user));
    }

    @PostMapping("update/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        Optional<User> updatedUser = updateUserUsecase.execute(id, userDtoMapper.toDomain(userDto));
        Map<String,Object> response = new HashMap<>();
        response.put("Message:", "Usuário atualizado com sucesso.");
        response.put("User data:", userDtoMapper.toDto(updatedUser.orElse(null)));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        String message = deleteUserUsecase.execute(id);
        return ResponseEntity.ok(message);
    }

}
