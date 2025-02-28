package products.murasaki.MurasakiProducts.infrastructure.persistence;

import jakarta.persistence.*;
import products.murasaki.MurasakiProducts.core.enums.MurasaKiProductsUserTypes;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;

    private MurasaKiProductsUserTypes userType;

    public UserEntity() {
    }

    public UserEntity( String name, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt, MurasaKiProductsUserTypes userType) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MurasaKiProductsUserTypes getUserType() {
        return userType;
    }

    public void setUserType(MurasaKiProductsUserTypes userType) {
        this.userType = userType;
    }
}
