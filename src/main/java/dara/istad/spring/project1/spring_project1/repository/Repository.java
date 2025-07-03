package dara.istad.spring.project1.spring_project1.repository;

import java.util.List;

public interface Repository<T,I> {
    List<T> findAll();
    I save(T t);
    I delete(String uuid);
}
