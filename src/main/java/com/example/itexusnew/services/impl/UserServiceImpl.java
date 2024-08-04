package com.example.itexusnew.services.impl;

import com.example.itexusnew.domain.User;
import com.example.itexusnew.repositories.UserRepository;
import com.example.itexusnew.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Пользователя с id %d не найдено.", id)));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        // Проверяем существование пользователя перед обновлением
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Пользователя с id %d не найдено.", id)));
        // Обновляем поля пользователя
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_name(user.getLast_name());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole_user_1(user.getRole_user_1());
        existingUser.setRole_user_2(user.getRole_user_2());
        existingUser.setRole_user_3(user.getRole_user_3());
        existingUser.setPhone_number_1(user.getPhone_number_1());
        existingUser.setPhone_number_2(user.getPhone_number_2());
        existingUser.setPhone_number_3(user.getPhone_number_3());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
