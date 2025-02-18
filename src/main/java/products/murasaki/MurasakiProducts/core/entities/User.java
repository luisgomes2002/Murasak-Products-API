package products.murasaki.MurasakiProducts.core.entities;

import java.util.Date;

public record User(
        Long id,
        String name,
        String email,
        String password,
        Date created_at,
        Date updated_at
) { }
