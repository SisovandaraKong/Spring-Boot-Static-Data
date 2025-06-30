package dara.istad.spring.project1.spring_project1.model.dto;

public record ProductResponseDto(
        String uuid,
        String name,
        String description,
        Double price,
        String image
) {

}
