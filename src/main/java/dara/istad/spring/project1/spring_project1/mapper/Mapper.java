package dara.istad.spring.project1.spring_project1.mapper;

import dara.istad.spring.project1.spring_project1.dto.UserCreateDto;
import dara.istad.spring.project1.spring_project1.dto.UserResponseDto;
import dara.istad.spring.project1.spring_project1.domain.User;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class Mapper {
    public static User mapFromUserCreateDtoToUser(UserCreateDto userCreateDto) {
        return new User(
                new Random().nextInt(9999),
                UUID.randomUUID().toString(),
                userCreateDto.name(),
                userCreateDto.email(),
                userCreateDto.password(),
                LocalDate.now()
        );
    }
    public static UserResponseDto mapFromUserToUserResponseDto(User user) {
        return new UserResponseDto(
                user.getUuid(),
                user.getName(),
                user.getEmail()
        );
    }
}
