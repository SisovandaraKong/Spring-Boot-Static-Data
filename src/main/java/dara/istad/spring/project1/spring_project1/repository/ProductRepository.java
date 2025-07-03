package dara.istad.spring.project1.spring_project1.repository;
import dara.istad.spring.project1.spring_project1.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductRepository implements Repository<Product,Integer> {

    private final Data data = new Data();
    private final List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        if (products.isEmpty()) {
        products.addAll(data.allProducts());
    }
        return products;
    }

    @Override
    public Integer save(Product product) {
        products.add(product);
        return 0;
    }

    @Override
    public Integer delete(String uuid) {
        boolean rowEffect = products.removeIf(product -> product.getUuid().equals(uuid));
        return rowEffect ? 1 : 0;
    }
}
