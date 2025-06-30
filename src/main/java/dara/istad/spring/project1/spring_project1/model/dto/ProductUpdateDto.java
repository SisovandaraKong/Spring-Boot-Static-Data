package dara.istad.spring.project1.spring_project1.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto(
        @NotBlank(message = "Name is required")
        String name,
        String description,
        @NotNull(message = "Price is required")
        Double price,
        @NotBlank(message = "Image is required")
        String image
) {
}
