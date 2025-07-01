package dara.istad.spring.project1.spring_project1.model.service;

import dara.istad.spring.project1.spring_project1.mapper.Mapper;
import dara.istad.spring.project1.spring_project1.model.dto.UserCreateDto;
import dara.istad.spring.project1.spring_project1.model.dto.UserResponseDto;
import dara.istad.spring.project1.spring_project1.model.dto.UserUpdateDto;
import dara.istad.spring.project1.spring_project1.model.entity.User;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private List<User> users = new ArrayList<>(List.of(
            new User(1, "a1b2c3d4-e5f6-7890-abcd-ef1234567890", "Alice", "alice@example.com", "password123", LocalDate.of(2024, 1, 10)),
            new User(2, "b2c3d4e5-f6a7-8901-bcde-fa2345678901", "Bob", "bob@example.com", "secure456", LocalDate.of(2024, 2, 15)),
            new User(3, "c3d4e5f6-a7b8-9012-cdef-ab3456789012", "Charlie", "charlie@example.com", "abc789", LocalDate.of(2024, 3, 20)),
            new User(4, "d4e5f6a7-b8c9-0123-def0-bc4567890123", "Dara", "dara@example.com", "pass001", LocalDate.of(2024, 4, 25)),
            new User(5, "e5f6a7b8-c9d0-1234-ef01-cd5678901234", "Eve", "eve@example.com", "wordpass", LocalDate.of(2024, 5, 5)),
            new User(6, "f6a7b8c9-d0e1-2345-f012-de6789012345", "Frank", "frank@example.com", "qwerty", LocalDate.of(2024, 6, 15)),
            new User(7, "a7b8c9d0-e1f2-3456-0123-ef7890123456", "Grace", "grace@example.com", "letmein", LocalDate.of(2024, 7, 22)),
            new User(8, "b8c9d0e1-f2a3-4567-1234-fg8901234567", "Henry", "henry@example.com", "12345678", LocalDate.of(2024, 8, 30)),
            new User(9, "c9d0e1f2-a3b4-5678-2345-gh9012345678", "Ivy", "ivy@example.com", "mypassword", LocalDate.of(2024, 9, 9)),
            new User(10, "d0e1f2a3-b4c5-6789-3456-hi0123456789", "Jack", "jack@example.com", "pass999", LocalDate.of(2024, 10, 19))
    ));

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user : users) {
            userResponseDtos.add(Mapper.mapFromUserToUserResponseDto(user));
        }
        return userResponseDtos;
    }

    @Override
    public UserResponseDto getUserByUuid(String uuid) {
        for (User user : users) {
            if (user.getUuid().equals(uuid)) {
                return Mapper.mapFromUserToUserResponseDto(user);
            }
        }
        return null;
    }

    @Override
    public UserResponseDto addUser(UserCreateDto userCreateDto) {
        User user = Mapper.mapFromUserCreateDtoToUser(userCreateDto);
        users.add(user);
        return Mapper.mapFromUserToUserResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(String uuid, UserUpdateDto userUpdateDto) {
        for (User user : users) {
            if (user.getUuid().equals(uuid)) {
                user.setName(userUpdateDto.name());
                user.setEmail(userUpdateDto.email());
                user.setPassword(userUpdateDto.password());
                return Mapper.mapFromUserToUserResponseDto(user);
            }
        }
        return null;
    }

    @Override
    public Integer deleteUserByUuid(String uuid) {
        users.removeIf(user -> user.getUuid().equals(uuid));
        return 0;
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Mapper.mapFromUserToUserResponseDto(user);
            }
        }
        return null;
    }
}
