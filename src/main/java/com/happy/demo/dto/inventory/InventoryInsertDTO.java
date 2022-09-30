package com.happy.demo.dto.inventory;


import java.math.BigDecimal;

public class InventoryInsertDTO {
    private String type;

    private BigDecimal rent;

    public InventoryInsertDTO() {
    }

    public InventoryInsertDTO(String type, BigDecimal rent) {
        this.type = type;
        this.rent = rent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }
}
