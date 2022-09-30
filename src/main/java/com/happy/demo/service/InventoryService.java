package com.happy.demo.service;

import com.happy.demo.dto.inventory.InventoryInsertDTO;
import com.happy.demo.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryService {
    Page<Inventory> findAllPage(Pageable pageable);

    Inventory getInventory(long id);

    void saveNewInventory(InventoryInsertDTO inventoryInsertDTO);

    void deleteById(long id);
}
