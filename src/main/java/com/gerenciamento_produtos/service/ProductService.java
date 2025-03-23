package com.gerenciamento_produtos.service;

import com.gerenciamento_produtos.entity.Product;
import com.gerenciamento_produtos.repository.ProductRepository;
import com.gerenciamento_produtos.service.exception.ProductNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Product service.
 */
@Service
public class ProductService {
  private final ProductRepository productRepository;

  /**
   * Instantiates a new Product service.
   *
   * @param productRepository the product repository
   */
  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  /**
   * Find by id product.
   *
   * @param id the id
   * @return the product
   * @throws ProductNotFoundException the product not found exception
   */
  public Product findById(Long id) throws ProductNotFoundException {
    return productRepository.findById(id)
        .orElseThrow(ProductNotFoundException::new);
  }

  /**
   * Create product.
   *
   * @param product the product
   * @return the product
   */
  public Product create(Product product) {
    return productRepository.save(product);
  }

  /**
   * Update product.
   *
   * @param id      the id
   * @param product the product
   * @return the product
   * @throws ProductNotFoundException the product not found exception
   */
  public Product update(Long id, Product product) throws ProductNotFoundException {
    Product fromDb = findById(id);

    fromDb.setName(product.getName());
    fromDb.setPrice(product.getPrice());

    return productRepository.save(fromDb);
  }

  /**
   * Delete product.
   *
   * @param id the id
   * @return the product
   * @throws ProductNotFoundException the product not found exception
   */
  public Product delete(Long id) throws ProductNotFoundException {
    Product product = findById(id);

    productRepository.deleteById(id);

    return product;
  }
}
