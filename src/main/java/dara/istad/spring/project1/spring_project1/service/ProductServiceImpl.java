package dara.istad.spring.project1.spring_project1.service;

import dara.istad.spring.project1.spring_project1.dto.ProductCreateDto;
import dara.istad.spring.project1.spring_project1.dto.ProductResponseDto;
import dara.istad.spring.project1.spring_project1.dto.ProductUpdateDto;
import dara.istad.spring.project1.spring_project1.domain.Product;
import dara.istad.spring.project1.spring_project1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final Product product;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> new ProductResponseDto(
                product.getUuid(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImage()
        )).toList();
    }

    @Override
    public ProductResponseDto getProductByUuid(String uuid) {
        return productRepository.findAll().stream()
                .filter(product -> product.getUuid().equals(uuid))
                .findFirst()
                .map(product -> new ProductResponseDto(
                        product.getUuid(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImage()
                ))
                .orElse(null);
    }

    @Override
    public ProductResponseDto addProduct(ProductCreateDto productCreateDto) {
        Product newProduct = new Product();
        newProduct.setId(new Random().nextInt(9999));
        newProduct.setUuid(UUID.randomUUID().toString());
        newProduct.setName(productCreateDto.name());
        newProduct.setDescription(productCreateDto.description());
        newProduct.setPrice(productCreateDto.price());
        newProduct.setImage(productCreateDto.image());
        newProduct.setCreatedDate(LocalDate.now());
        productRepository.save(newProduct);
        return new ProductResponseDto(
                newProduct.getUuid(),
                newProduct.getName(),
                newProduct.getDescription(),
                newProduct.getPrice(),
                newProduct.getImage()
        );
    }

    @Override
    public Integer deleteProductByUuid(String uuid) {
        productRepository.delete(uuid);
        return 0;
    }


    @Override
    public ProductResponseDto updateProduct(String uuid, ProductUpdateDto productUpdateDto) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getUuid().equals(uuid))
                .findFirst()
                .map(oldProduct ->{
                    oldProduct.setName(productUpdateDto.name());
                    oldProduct.setDescription(productUpdateDto.description());
                    oldProduct.setPrice(productUpdateDto.price());
                    oldProduct.setImage(productUpdateDto.image());
                    return new ProductResponseDto(
                            oldProduct.getUuid(),
                            oldProduct.getName(),
                            oldProduct.getDescription(),
                            oldProduct.getPrice(),
                            oldProduct.getImage());
                }).orElse(null);
    }
}
