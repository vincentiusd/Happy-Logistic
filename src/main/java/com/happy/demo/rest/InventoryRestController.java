package com.happy.demo.rest;

import com.happy.demo.dto.inventory.InventoryInsertDTO;
import com.happy.demo.entity.Inventory;
import com.happy.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventories")
public class InventoryRestController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<?> getAllInventory(
    @RequestParam(defaultValue = "1") Integer page
    ){
        Pageable pageable = PageRequest.of(page - 1,10, Sort.by("id"));

        Page<Inventory> inventories = inventoryService.findAllPage(pageable);

        if(page > inventories.getTotalPages()){
            throw new RuntimeException("Page not found");
        }

        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getInventory(
            @PathVariable long id
    ){
        Inventory inventory = inventoryService.getInventory(id);

        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createInventory(
            @RequestBody InventoryInsertDTO inventoryInsertDTO
            ){

        inventoryService.saveNewInventory(inventoryInsertDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteInventory(
            @PathVariable long id
    ){

        inventoryService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
