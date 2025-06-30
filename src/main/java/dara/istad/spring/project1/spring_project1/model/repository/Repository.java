package dara.istad.spring.project1.spring_project1.model.repository;

import dara.istad.spring.project1.spring_project1.model.entity.Product;

import java.util.List;

public interface Repository<T,I> {
    List<T> findAll();
    I save(T t);
    I delete(String uuid);
}
