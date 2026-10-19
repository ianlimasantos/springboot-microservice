package com.ms.user.controllers;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.dtos.UserResponseDto;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        var userResponseDto = this.userService.save(userRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @GetMapping("/users")
    public RespondeEntity<UserResponseDto> getUser(UUID id){
        return ResponseEntity.status(HttpStatus.)
    }
}
