package com.example.segundos_api.service;

import com.example.segundos_api.dto.request.UserRequest;
import com.example.segundos_api.model.User;
import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);
    List<User> getAllUsers();
    User getUserById(Long id);
    User findByEmailUsuario(String emailUsuario);
}