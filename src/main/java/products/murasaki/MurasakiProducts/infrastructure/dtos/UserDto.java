package products.murasaki.MurasakiProducts.infrastructure.dtos;

import java.util.Date;

public record UserDto(
        Long id,
        String name,
        String email,
        String password,
        Date created_at,
        Date updated_at
) {}
