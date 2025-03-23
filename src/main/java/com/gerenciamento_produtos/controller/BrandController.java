package com.gerenciamento_produtos.controller;

import com.gerenciamento_produtos.controller.dto.BrandCreationDto;
import com.gerenciamento_produtos.controller.dto.BrandDto;
import com.gerenciamento_produtos.entity.Brand;
import com.gerenciamento_produtos.service.BrandService;
import com.gerenciamento_produtos.service.exception.BrandNotFoundException;
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
@RequestMapping("/brands")
public class BrandController {
  private final BrandService service;

  @Autowired
  public BrandController(BrandService categoryService) {
    this.service = categoryService;
  }

  @GetMapping
  public List<BrandDto> findAllBrand() {
    List<Brand> allB = service.findAll();

    return allB.stream().map(BrandDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public BrandDto findBrand(@PathVariable Long id) throws BrandNotFoundException {
    return BrandDto.fromEntity(service.findById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BrandDto createBrand(@RequestBody BrandCreationDto brandCreationDto) {
    return BrandDto.fromEntity(service.create(brandCreationDto.toEntity()));
  }

  @PutMapping("/{id}")
  public BrandDto updateBrand(
      @PathVariable Long id,
      @RequestBody BrandCreationDto brandCreationDto
  ) throws BrandNotFoundException {
    return BrandDto.fromEntity(service.update(id, brandCreationDto.toEntity()));
  }

  @DeleteMapping("/{id}")
  public BrandDto deleteBrand(@PathVariable Long id) throws BrandNotFoundException {
    return BrandDto.fromEntity(service.delete(id));
  }
}
