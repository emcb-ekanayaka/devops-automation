package com.inventory.printit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDto {

    private String id;
    private String warehouseCode;
    private String warehouseName;
    private String warehouseLocation;
}
