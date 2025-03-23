package com.gerenciamento_produtos.controller.dto;

import com.gerenciamento_produtos.entity.Brand;

public record BrandDto(Long id, String name) {
  public static BrandDto fromEntity(Brand brand) {
    return new BrandDto(brand.getId(), brand.getName());
  }
}
