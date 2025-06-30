package dara.istad.spring.project1.spring_project1.model.service;

import dara.istad.spring.project1.spring_project1.model.dto.ProductCreateDto;
import dara.istad.spring.project1.spring_project1.model.dto.ProductResponseDto;
import dara.istad.spring.project1.spring_project1.model.dto.ProductUpdateDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductByUuid(String uuid);
    ProductResponseDto addProduct(ProductCreateDto productCreateDto);
    Integer deleteProductByUuid(String uuid);
    ProductResponseDto updateProduct(String uuid,ProductUpdateDto productUpdateDto);
}
