package com.inventory.printit.service;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseComHasWhrDto;

import java.sql.SQLException;

public interface CompanyHasWarehouseService {

    CommonResponseDto saveCompanyHasWarehouse(RequestRegistryDto dto);
    CommonResponseDto updateCompanyHasWarehouse(RequestRegistryDto dto, Integer companyHasWarehouseId);
    CommonResponseDto removeCompanyHasWarehouse(Integer companyHasWarehouseId);
    PaginatedResponseComHasWhrDto allCompanyHasWarehouses() throws SQLException;

}
