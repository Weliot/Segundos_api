package com.example.segundos_api.controller;

import com.example.segundos_api.dto.request.UserRequest;
import com.example.segundos_api.dto.response.UserResponse;
import com.example.segundos_api.model.User;
import com.example.segundos_api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.segundos_api.dto.UserMapper;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuários")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("CriarUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        User createdUser = userService.createUser(userRequest);
        return UserMapper.toResponse(createdUser);
    }

    @GetMapping("ListarUsuarios")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return UserMapper.toResponse(user);
    }

    @PutMapping("UsuarioPorEmail/{emailUsuario}")
    public UserResponse getByEmail(@PathVariable String emailUsuario) {
        User user = userService.findByEmailUsuario(emailUsuario);
        return UserMapper.toResponse(user);
    }
}