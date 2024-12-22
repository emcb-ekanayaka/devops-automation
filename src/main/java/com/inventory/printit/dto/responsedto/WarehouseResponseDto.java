package com.inventory.printit.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseResponseDto {
    private String id;
    private String warehouseCode;
    private String warehouseName;
    private String warehouseLocation;
}
