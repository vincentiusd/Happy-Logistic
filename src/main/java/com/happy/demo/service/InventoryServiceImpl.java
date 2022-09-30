package com.happy.demo.service;

import com.happy.demo.dto.inventory.InventoryInsertDTO;
import com.happy.demo.entity.Inventory;
import com.happy.demo.exception.NotFoundException;
import com.happy.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Page<Inventory> findAllPage(Pageable pageable) {

        return inventoryRepository.findAll(pageable);
    }

    @Override
    public Inventory getInventory(long id) {
        return inventoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No inventory found")
        );
    }

    @Override
    public void saveNewInventory(InventoryInsertDTO inventoryInsertDTO) {
        Inventory inventory = new Inventory(
                inventoryInsertDTO.getType(),
                inventoryInsertDTO.getRent()
        );

        inventoryRepository.save(inventory);
    }

    @Override
    public void deleteById(long id) {
        inventoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No inventory found")
        );
        inventoryRepository.deleteById(id);
    }
}
