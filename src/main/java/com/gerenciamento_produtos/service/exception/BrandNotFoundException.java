package com.gerenciamento_produtos.service.exception;

public class BrandNotFoundException extends Exception {

  public BrandNotFoundException() {
    super("Marca não encontrada!");
  }
}
