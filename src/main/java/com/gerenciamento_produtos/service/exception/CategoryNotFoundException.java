package com.gerenciamento_produtos.service.exception;

public class CategoryNotFoundException extends Exception {

  public CategoryNotFoundException() {
    super("Categoria não encontrada!");
  }
}
