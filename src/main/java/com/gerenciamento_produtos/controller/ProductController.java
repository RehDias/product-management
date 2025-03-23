package com.gerenciamento_produtos.controller;

import com.gerenciamento_produtos.controller.dto.ProductCreationDto;
import com.gerenciamento_produtos.controller.dto.ProductDto;
import com.gerenciamento_produtos.entity.Product;
import com.gerenciamento_produtos.service.ProductService;
import com.gerenciamento_produtos.service.exception.ProductNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService service;

  @Autowired
  public ProductController(ProductService productService) {
    this.service = productService;
  }

  @GetMapping
  public List<ProductDto> getAllProducts() {
    List<Product> allP = service.findAll();

    return allP.stream().map(ProductDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public ProductDto getProductById(@PathVariable Long id) throws ProductNotFoundException {
    return ProductDto.fromEntity(service.findById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDto createProduct(@RequestBody ProductCreationDto productCreationDto) {
    return ProductDto.fromEntity(service.create(productCreationDto.toEntity()));
  }

  @PutMapping("/{id}")
  public ProductDto updateProduct(
      @PathVariable Long id,
      @RequestBody ProductCreationDto productCreationDto) throws ProductNotFoundException {
    return ProductDto.fromEntity(service.update(id, productCreationDto.toEntity()));
  }

  @DeleteMapping("/{id}")
  public ProductDto deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
    return ProductDto.fromEntity(service.delete(id));
  }
}
