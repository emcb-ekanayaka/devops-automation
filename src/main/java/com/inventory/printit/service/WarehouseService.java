package com.inventory.printit.service;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseWarehouseDto;

import java.sql.SQLException;

public interface WarehouseService {
    CommonResponseDto saveWarehouse(RequestRegistryDto dto);
    CommonResponseDto updateWarehouse(RequestRegistryDto dto, String warehouseId);
    CommonResponseDto removeWarehouse(String warehouseId);
    PaginatedResponseWarehouseDto allWarehouses() throws SQLException;
    PaginatedResponseWarehouseDto warehouseById(String warehouseCode) throws SQLException;
}
