package products.murasaki.MurasakiProducts.core.entities;

import products.murasaki.MurasakiProducts.core.enums.MurasaKiProductsUserTypes;

import java.time.LocalDateTime;

public record User(
        Long id,
        String name,
        String email,
        String password,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        MurasaKiProductsUserTypes userType
) { }
