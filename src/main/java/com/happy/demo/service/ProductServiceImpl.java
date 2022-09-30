package com.happy.demo.service;

import com.happy.demo.dto.product.ProductGridDTO;
import com.happy.demo.dto.product.ProductInsertDTO;
import com.happy.demo.entity.Customer;
import com.happy.demo.entity.Inventory;
import com.happy.demo.entity.Product;
import com.happy.demo.exception.NotFoundException;
import com.happy.demo.repository.CustomerRepository;
import com.happy.demo.repository.InventoryRepository;
import com.happy.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void saveNewProduct(String username, Long id, ProductInsertDTO dto) {

        Customer customer = customerRepository.findByUsername(username);

        Inventory inventory = inventoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No inventory found")
        );

        Product newProduct = new Product(
                dto.getName(),
                dto.getType(),
                customer,
                inventory
        );

        productRepository.save(newProduct);

    }

    @Override
    public Page<ProductGridDTO> findAllDTO(Pageable pageable, String username) {
        return productRepository.findAllDTOPage(pageable);
    }
}
