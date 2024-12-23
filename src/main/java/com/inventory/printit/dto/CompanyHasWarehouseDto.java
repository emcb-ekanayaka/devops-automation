package com.inventory.printit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyHasWarehouseDto {

    private CompanyDto companyId;
    private WarehouseDto warehouseId;
}
