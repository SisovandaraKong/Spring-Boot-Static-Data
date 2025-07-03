package dara.istad.spring.project1.spring_project1.service;

import dara.istad.spring.project1.spring_project1.dto.ProductCreateDto;
import dara.istad.spring.project1.spring_project1.dto.ProductResponseDto;
import dara.istad.spring.project1.spring_project1.dto.ProductUpdateDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductByUuid(String uuid);
    ProductResponseDto addProduct(ProductCreateDto productCreateDto);
    Integer deleteProductByUuid(String uuid);
    ProductResponseDto updateProduct(String uuid,ProductUpdateDto productUpdateDto);
}
