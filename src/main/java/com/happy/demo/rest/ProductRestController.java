package com.happy.demo.rest;


import com.happy.demo.dto.product.ProductGridDTO;
import com.happy.demo.dto.product.ProductInsertDTO;
import com.happy.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    private ResponseEntity<?> getAllProduct(
            @RequestParam(defaultValue = "1") Integer page
    ){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Pageable pageable = PageRequest.of(page - 1,10, Sort.by("id"));

        Page<ProductGridDTO> productPage = productService.findAllDTO(pageable, username);

        if(page > productPage.getTotalPages()){
            throw new RuntimeException("Page not found");
        }

        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }


    @PostMapping(value = "/{id}")
    public ResponseEntity<?> createNewProduct(
            @PathVariable Long id,
            @RequestBody ProductInsertDTO dto
            ){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        productService.saveNewProduct(username, id, dto);

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
