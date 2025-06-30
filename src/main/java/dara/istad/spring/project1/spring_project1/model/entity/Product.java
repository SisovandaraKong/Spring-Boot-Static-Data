package dara.istad.spring.project1.spring_project1.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
    private Integer id;
    private String uuid;
    private String name;
    private String description;
    private Double price;
    private String image;
    private LocalDate createdDate;
}
