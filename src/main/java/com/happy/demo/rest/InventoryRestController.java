package com.happy.demo.rest;

import com.happy.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventories")
public class InventoryRestController {

    @Autowired
    private InventoryService inventoryService;
}
