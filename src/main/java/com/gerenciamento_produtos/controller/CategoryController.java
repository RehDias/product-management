package com.gerenciamento_produtos.controller;

import com.gerenciamento_produtos.controller.dto.CategoryCreationDto;
import com.gerenciamento_produtos.controller.dto.CategoryDto;
import com.gerenciamento_produtos.entity.Category;
import com.gerenciamento_produtos.service.CategoryService;
import com.gerenciamento_produtos.service.exception.CategoryNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
  private final CategoryService service;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.service = categoryService;
  }

  @GetMapping
  public List<CategoryDto> findAllCategory() {
    List<Category> allC = service.findAll();

    return allC.stream().map(CategoryDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public CategoryDto findCategory(@PathVariable Long id) throws CategoryNotFoundException {
    return CategoryDto.fromEntity(service.findById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CategoryDto createCategory(@RequestBody CategoryCreationDto categoryCreationDto) {
    return CategoryDto.fromEntity(service.create(categoryCreationDto.toEntity()));
  }

  @PutMapping("/{id}")
  public CategoryDto updateCategory(
      @PathVariable Long id,
      @RequestBody CategoryCreationDto categoryCreationDto
  ) throws CategoryNotFoundException {
    return CategoryDto.fromEntity(service.update(id, categoryCreationDto.toEntity()));
  }

  @DeleteMapping("/{id}")
  public CategoryDto deleteCategory(@PathVariable Long id) throws CategoryNotFoundException {
    return CategoryDto.fromEntity(service.delete(id));
  }
}
