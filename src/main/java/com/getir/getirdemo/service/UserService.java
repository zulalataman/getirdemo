package com.getir.getirdemo.service;

import com.getir.getirdemo.model.User;
import com.getir.getirdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User deleteUserByMail(String mail) {
        User user = userRepository.findByMail(mail);
        userRepository.delete(user);
        return user;
    }

    public User addNewUser(User user) {
        return userRepository.save(user);
    }
}
