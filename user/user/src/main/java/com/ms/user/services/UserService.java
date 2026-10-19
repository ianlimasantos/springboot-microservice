package com.ms.user.services;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.dtos.UserResponseDto;
import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer){
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserResponseDto save(UserRecordDto userRecordDto){
        var userModel = new UserModel(userRecordDto);
        var savedModel = userRepository.save(userModel);
        var userResponseDto = new UserResponseDto(savedModel.getUserId(), savedModel.getName(), savedModel.getEmail());
        userProducer.publishMessageEmail(userResponseDto);
        return userResponseDto;
    }


}
