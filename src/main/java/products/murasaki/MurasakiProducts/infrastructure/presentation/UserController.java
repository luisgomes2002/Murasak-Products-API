package products.murasaki.MurasakiProducts.infrastructure.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import products.murasaki.MurasakiProducts.infrastructure.persistence.UserEntity;

@RestController
@RequestMapping("api/user/")
public class UserController {

    @PostMapping("create")
    public String createUser(@RequestBody UserEntity user){
        return "User crinado";
    }
}
