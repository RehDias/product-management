package com.gerenciamento_produtos.service.exception;

public class ProductNotFoundException extends Exception {

  public ProductNotFoundException() {
    super("Produto não encontrado!");
  }
}
