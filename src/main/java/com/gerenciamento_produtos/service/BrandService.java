package com.gerenciamento_produtos.service;

import com.gerenciamento_produtos.entity.Brand;
import com.gerenciamento_produtos.repository.BrandRepository;
import com.gerenciamento_produtos.service.exception.BrandNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
  private final BrandRepository brandRepository;

  @Autowired
  public BrandService(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  public List<Brand> findAll() {
    return brandRepository.findAll();
  }

  public Brand findById(Long id) throws BrandNotFoundException {
    return brandRepository.findById(id)
        .orElseThrow(BrandNotFoundException::new);
  }

  public Brand create(Brand brand) {
    return brandRepository.save(brand);
  }

  public Brand update(Long id, Brand brand) throws BrandNotFoundException {
    Brand fromDb = findById(id);

    fromDb.setName(brand.getName());

    return brandRepository.save(fromDb);
  }

  public Brand delete(Long id) throws BrandNotFoundException {
    Brand brand = findById(id);

    brandRepository.deleteById(id);

    return brand;
  }
}
