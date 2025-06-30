package dara.istad.spring.project1.spring_project1.controller;


import dara.istad.spring.project1.spring_project1.model.dto.ProductCreateDto;
import dara.istad.spring.project1.spring_project1.model.dto.ProductResponseDto;
import dara.istad.spring.project1.spring_project1.model.dto.ProductUpdateDto;
import dara.istad.spring.project1.spring_project1.model.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Map<String,Object> getAllProducts() {
        return Map.of(
                "Message", "Get all products",
                "count", productService.getAllProducts().size(),
                "products", productService.getAllProducts()
        );
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{uuid}")
    public Map<String,Object> getProductById(@PathVariable String uuid) {
        return Map.of(
                "Message", "Get product by uuid",
                "product", productService.getProductByUuid(uuid)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Map<String,Object> addProduct(@Valid @RequestBody ProductCreateDto productCreateDto) {
        return Map.of(
                "Message", "Product is saved",
                "product", productService.addProduct(productCreateDto)
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{uuid}")
    public Map<String,Object> updateProduct(@PathVariable String uuid,@RequestBody ProductUpdateDto productUpdateDto) {
        productService.updateProduct(uuid, productUpdateDto);
        return Map.of(
                "Message", "Product is updated",
                "product", productService.getProductByUuid(uuid)
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{uuid}")
    public Map<String,Object> deleteProduct(@PathVariable String uuid) {
        return Map.of(
                "Message", "Product is deleted",
                "product", productService.deleteProductByUuid(uuid)
        );
    }
}
