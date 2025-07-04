package dara.istad.spring.project1.spring_project1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductUpdateDto(
        @NotBlank(message = "Name is required")
        String name,
        String description,
        @NotNull(message = "Price is required")
        @Positive
        Double price,
        @NotBlank(message = "Image is required")
        String image
) {
}
