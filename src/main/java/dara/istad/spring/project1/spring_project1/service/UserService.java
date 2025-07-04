package dara.istad.spring.project1.spring_project1.service;

import dara.istad.spring.project1.spring_project1.dto.UserCreateDto;
import dara.istad.spring.project1.spring_project1.dto.UserResponseDto;
import dara.istad.spring.project1.spring_project1.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserByUuid(String uuid);
    UserResponseDto addUser(UserCreateDto userCreateDto);
    UserResponseDto updateUserbyUuid(String uuid, UserUpdateDto userUpdateDto);
    Integer deleteUserByUuid(String uuid);
    UserResponseDto getUserByEmail(String email,String name);
}
