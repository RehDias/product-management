package com.gerenciamento_produtos.controller.dto;

import com.gerenciamento_produtos.entity.Brand;

public record BrandCreationDto(String name) {
  public Brand toEntity() {
    return new Brand(name);
  }
}
