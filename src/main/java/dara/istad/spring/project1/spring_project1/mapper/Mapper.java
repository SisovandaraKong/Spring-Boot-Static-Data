package dara.istad.spring.project1.spring_project1.mapper;

import dara.istad.spring.project1.spring_project1.model.dto.ProductCreateDto;
import dara.istad.spring.project1.spring_project1.model.dto.ProductResponseDto;
import dara.istad.spring.project1.spring_project1.model.dto.UserCreateDto;
import dara.istad.spring.project1.spring_project1.model.dto.UserResponseDto;
import dara.istad.spring.project1.spring_project1.model.entity.Product;
import dara.istad.spring.project1.spring_project1.model.entity.User;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Mapper {
    public static Product mapFromProductCreateDtoToProduct(ProductCreateDto productCreateDto) {
        return new Product(
                new Random().nextInt(9999),
                UUID.randomUUID().toString(),
                productCreateDto.name(),
                productCreateDto.description(),
                productCreateDto.price(),
                productCreateDto.image(),
                LocalDate.now()
        );
    }
    public static ProductResponseDto mapFromProductToProductResponseDto(Product product) {
        return new ProductResponseDto(
                product.getUuid(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImage()
        );
    }
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
