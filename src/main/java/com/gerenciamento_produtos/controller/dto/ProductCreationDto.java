package com.gerenciamento_produtos.controller.dto;

import com.gerenciamento_produtos.entity.Product;

public record ProductCreationDto(String name, Double price) {
  public Product toEntity() {
    return new Product(name, price);
  }
}
