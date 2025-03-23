package com.gerenciamento_produtos.controller.dto;

import com.gerenciamento_produtos.entity.Category;

public record CategoryDto(Long id, String name) {
  public static CategoryDto fromEntity(Category category) {
    return new CategoryDto(category.getId(), category.getName());
  }
}
