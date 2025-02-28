package products.murasaki.MurasakiProducts.infrastructure.dtos;

import products.murasaki.MurasakiProducts.core.enums.MurasaKiProductsUserTypes;

import java.time.LocalDateTime;
import java.util.Date;

public record UserDto(
        Long id,
        String name,
        String email,
        String password,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        MurasaKiProductsUserTypes userType
) {}
