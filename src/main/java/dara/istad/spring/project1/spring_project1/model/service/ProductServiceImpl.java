package dara.istad.spring.project1.spring_project1.model.service;

import dara.istad.spring.project1.spring_project1.mapper.Mapper;
import dara.istad.spring.project1.spring_project1.model.dto.ProductCreateDto;
import dara.istad.spring.project1.spring_project1.model.dto.ProductResponseDto;
import dara.istad.spring.project1.spring_project1.model.dto.ProductUpdateDto;
import dara.istad.spring.project1.spring_project1.model.entity.Product;
import dara.istad.spring.project1.spring_project1.model.repository.Data;
import dara.istad.spring.project1.spring_project1.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final Product product;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        final List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productResponseDtoList.add(Mapper.mapFromProductToProductResponseDto(product));
        }
        return productResponseDtoList;
    }

    @Override
    public ProductResponseDto getProductByUuid(String uuid) {
        for (Product product : productRepository.findAll()) {
            if (product.getUuid().equals(uuid)) {
                return Mapper.mapFromProductToProductResponseDto(product);
            }
        }
        return null;
    }

    @Override
    public ProductResponseDto addProduct(ProductCreateDto productCreateDto) {
        productRepository.save(Mapper.mapFromProductCreateDtoToProduct(productCreateDto));
        return Mapper.mapFromProductToProductResponseDto(Mapper.mapFromProductCreateDtoToProduct(productCreateDto));
    }

    @Override
    public Integer deleteProductByUuid(String uuid) {
        productRepository.delete(uuid);
        return 0;
    }


    @Override
    public ProductResponseDto updateProduct(String uuid, ProductUpdateDto productUpdateDto) {
        for (Product product : productRepository.findAll()) {
            if (product.getUuid().equals(uuid)) {
                product.setName(productUpdateDto.name());
                product.setDescription(productUpdateDto.description());
                product.setPrice(productUpdateDto.price());
                product.setImage(productUpdateDto.image());
                return Mapper.mapFromProductToProductResponseDto(product);
            }
        }
        return null;
    }
}
