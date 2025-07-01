package dara.istad.spring.project1.spring_project1.model.service;

import dara.istad.spring.project1.spring_project1.model.dto.UserCreateDto;
import dara.istad.spring.project1.spring_project1.model.dto.UserResponseDto;
import dara.istad.spring.project1.spring_project1.model.dto.UserUpdateDto;
import dara.istad.spring.project1.spring_project1.model.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserByUuid(String uuid);
    UserResponseDto addUser(UserCreateDto userCreateDto);
    UserResponseDto updateUser(String uuid, UserUpdateDto userUpdateDto);
    Integer deleteUserByUuid(String uuid);
    UserResponseDto getUserByEmail(String email);
}
