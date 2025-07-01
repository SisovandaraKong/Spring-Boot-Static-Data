package dara.istad.spring.project1.spring_project1.model.dto;

public record UserCreateDto(
        String name,
        String email,
        String password
) {
}
