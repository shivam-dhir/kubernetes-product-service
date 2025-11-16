package com.shivam.product.controller;

import com.shivam.product.dto.ProductRequest;
import com.shivam.product.dto.ProductResponse;
import com.shivam.product.model.Product;
import com.shivam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    // @DeleteMapping expects an empty response body, i.e. nothing should be returned after deletion.
    @DeleteMapping(value = "/delete/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String name) {
        productService.deleteProduct(name);
        //return "Product deleted successfully";
    }
}
