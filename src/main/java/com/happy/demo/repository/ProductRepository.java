package com.happy.demo.repository;

import com.happy.demo.dto.product.ProductGridDTO;
import com.happy.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT new com.happy.demo.dto.product.ProductGridDTO(pro.id, pro.name, pro.type, cus.id, inv.id)
            FROM Product AS pro
            JOIN pro.customer AS cus
            JOIN pro.inventory AS inv
            """)
    public Page<ProductGridDTO> findAllDTOPage(Pageable pageable);
}