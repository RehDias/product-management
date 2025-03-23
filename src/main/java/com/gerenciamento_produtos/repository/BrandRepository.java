package com.gerenciamento_produtos.repository;

import com.gerenciamento_produtos.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Brand repository.
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {}
