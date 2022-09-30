package com.happy.demo.service;

import com.happy.demo.dto.product.ProductGridDTO;
import com.happy.demo.dto.product.ProductInsertDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    void saveNewProduct(String username, Long id, ProductInsertDTO dto);

    Page<ProductGridDTO> findAllDTO(Pageable pageable, String username);
}
