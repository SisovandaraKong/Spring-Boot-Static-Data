package dara.istad.spring.project1.spring_project1.dto;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDto(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "Password is required")
        String password
) {
}
