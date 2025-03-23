package com.gerenciamento_produtos.controller.dto;

import com.gerenciamento_produtos.entity.Product;

public record ProductDto(Long id, String nome, Double price) {
  public static ProductDto fromEntity(Product product) {
    return new ProductDto(product.getId(), product.getName(), product.getPrice());
  }
}
