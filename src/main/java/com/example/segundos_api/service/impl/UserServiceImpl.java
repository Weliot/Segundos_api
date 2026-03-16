package com.example.segundos_api.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.segundos_api.dto.request.UserRequest;
import com.example.segundos_api.model.User;
import com.example.segundos_api.repository.UserRepository;
import com.example.segundos_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setNomeUsuario(userRequest.nomeUsuario());
        user.setEmailUsuario(userRequest.emailUsuario());

        String hashPassword = passwordEncoder.encode(userRequest.passwordUsuario());
        user.setPasswordUsuario(hashPassword);
        
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    @Override
    public User getUserById(Long id) {
        // Your logic here (e.g., fetch user from database)
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        // Your logic here (e.g., fetch all users from database)
        return userRepository.findAll();
    }

    @Override
    public User findByEmailUsuario(String emailUsuario) {
        // Your logic here (e.g., fetch user by email from database)
        return userRepository.findByEmailUsuario(emailUsuario);
    }
    
}