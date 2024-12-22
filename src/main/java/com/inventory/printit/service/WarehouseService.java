package com.inventory.printit.service;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;

public interface WarehouseService {
    CommonResponseDto saveWarehouse(RequestRegistryDto dto);
    CommonResponseDto updateWarehouse(RequestRegistryDto dto, String warehouseId);
}
