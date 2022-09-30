package com.happy.demo.dto.product;

public class ProductGridDTO {

    private final Long id;
    private final String name;
    private final String type;
    private final Long customerId;
    private final Long inventoryId;

    public ProductGridDTO(Long id, String name, String type, Long customerId, Long inventoryId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.customerId = customerId;
        this.inventoryId = inventoryId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getInventoryId() {
        return inventoryId;
    }
}
