package com.gerenciamento_produtos.controller.dto;

import com.gerenciamento_produtos.entity.Category;

public record CategoryCreationDto(String name) {
  public Category toEntity() {
    return new Category(name);
  }
}
