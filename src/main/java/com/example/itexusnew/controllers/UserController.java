package com.example.itexusnew.controllers;

import com.example.itexusnew.domain.User;
import com.example.itexusnew.repositories.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "user", description = "User Endpoint")
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

@Autowired
    private UserRepository userRepository;

    // Получить всех пользователей
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Получить пользователя по ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id)
                .map(user -> {
                    System.out.println("Найден пользователь: " + user); // Выводим информацию о пользователе в консоль
                    return ResponseEntity.ok().body(user);
                })
                .orElseGet(() -> {
                    System.out.println("Пользователь с ID " + id + " не найден."); // Выводим сообщение в консоль при неудаче
                    return ResponseEntity.notFound().build();
                });
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        try {
            // Здесь нужно добавить логику по обработке ролей и номеров телефонов
            User savedUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            // Логирование ошибки (если необходимо)
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());

            // Возвращаем ответ с ошибкой
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Или вы можете вернуть собственный объект с сообщением об ошибке
        }
    }

    // Удалить пользователя
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Обновить пользователя
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirst_name(userDetails.getFirst_name());
                    user.setLast_name(userDetails.getLast_name());
                    user.setEmail(userDetails.getEmail());
                    user.setRole_user_1(userDetails.getRole_user_1());
                    user.setRole_user_2(userDetails.getRole_user_2());
                    user.setRole_user_3(userDetails.getRole_user_3());
                    user.setPhone_number_1(userDetails.getPhone_number_1());
                    user.setPhone_number_2(userDetails.getPhone_number_2());
                    user.setPhone_number_3(userDetails.getPhone_number_3());
                    User updatedUser = userRepository.save(user);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
