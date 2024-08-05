package com.example.itexusnew.domain;

import com.example.itexusnew.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
@Entity
public class User extends BaseEntity {

    @NotBlank(message = "Поле должно быть заполнено!")
    @NotNull(message = "Поле должно быть заполнено!")
    @Column(name = "first_name")
    private String first_name;

    @NotBlank(message = "Поле должно быть заполнено!")
    @NotNull(message = "Поле должно быть заполнено!")
    @Column(name = "last_name")
    private String last_name;

    @NotBlank(message = "Поле должно быть заполнено!")
    @NotNull(message = "Поле должно быть заполнено!")
    @Column(name = "email", unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email должен иметь формат *******@**.*")
    private String email;

    @Pattern(regexp = "^375\\d{9}$", message = "Телефон должен иметь формат 375*********")
    @NotBlank(message = "Поле должно быть заполнено!")
    @NotNull(message = "Поле должно быть заполнено!")
    @Column(name = "phone_number_1", unique = true)
    private String phone_number_1;

    @Pattern(regexp = "^375\\d{9}$", message = "Телефон должен иметь формат 375*********")
    @Column(name = "phone_number_2", unique = true)
    private String phone_number_2;

    @Pattern(regexp = "^375\\d{9}$", message = "Телефон должен иметь формат 375*********")
    @Column(name = "phone_number_3", unique = true)
    private String phone_number_3;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Поле должно быть заполнено!")
    @Column(name = "role_user_1")
    private Role role_user_1;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_user_2")
    private Role role_user_2;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_user_3")
    private Role role_user_3;

}
