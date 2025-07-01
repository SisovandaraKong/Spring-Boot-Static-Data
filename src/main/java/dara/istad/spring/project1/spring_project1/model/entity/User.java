package dara.istad.spring.project1.spring_project1.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String uuid;
    private String name;
    private String email;
    private String password;
    private LocalDate createdDate;
}
