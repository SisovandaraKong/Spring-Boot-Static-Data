package dara.istad.spring.project1.spring_project1.model.repository;
import dara.istad.spring.project1.spring_project1.model.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Data {
    public List<Product> allProducts() {
        List<Product> products = new ArrayList<>(List.of(
                new Product(1,"78b28c62-1502-43b1-b477-19f81eda5ea2","Coca", "Best when spicy food",2.1,"https://media.istockphoto.com/id/487787108/photo/can-of-coca-cola-on-ice.jpg?s=612x612&w=0&k=20&c=xDSO_nl0qeDMBZJBJk09jj5_UeQkyQ70QdXuDMByCaY=", LocalDate.of(2025,3,25)),
                new Product(2,"11b28c62-9802-43b1-v77-89f7veda5ea23","Beer", "Best when you got sad",1.5,"https://media.istockphoto.com/id/487787108/photo/can-of-coca-cola-on-ice.jpg?s=612x612&w=0&k=20&c=xDSO_nl0qeDMBZJBJk09jj5_UeQkyQ70QdXuDMByCaY=",LocalDate.of(2025,3,25)),
                new Product(3,"53b28c21-f302-4335-2j7-26v7veda5eag2","Milk", "Best for kid",5.00,"https://media.istockphoto.com/id/487787108/photo/can-of-coca-cola-on-ice.jpg?s=612x612&w=0&k=20&c=xDSO_nl0qeDMBZJBJk09jj5_UeQkyQ70QdXuDMByCaY=", LocalDate.of(2025,3,25))
        ));
        return products;
    }
}
