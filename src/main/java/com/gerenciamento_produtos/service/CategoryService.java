package com.gerenciamento_produtos.service;

import com.gerenciamento_produtos.entity.Category;
import com.gerenciamento_produtos.repository.CategoryRepository;
import com.gerenciamento_produtos.service.exception.CategoryNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Long id) throws CategoryNotFoundException {
    return categoryRepository.findById(id)
        .orElseThrow(CategoryNotFoundException::new);
  }

  public Category create(Category category) {
    return categoryRepository.save(category);
  }

  public Category update(Long id, Category category) throws CategoryNotFoundException {
    Category fromDb = findById(id);

    fromDb.setName(category.getName());

    return categoryRepository.save(fromDb);
  }

  public Category delete(Long id) throws CategoryNotFoundException {
    Category category = findById(id);

    categoryRepository.deleteById(id);

    return category;
  }
}
