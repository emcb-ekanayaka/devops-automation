package com.inventory.printit.dto.responsedto;

import com.inventory.printit.dto.CompanyDto;
import com.inventory.printit.dto.WarehouseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyHasWarehouseResponseDto {
    private Integer id;
    private CompanyDto companyId;
    private WarehouseDto warehouseId;
}
