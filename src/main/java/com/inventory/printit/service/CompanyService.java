package com.inventory.printit.service;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseCompanyDto;

import java.sql.SQLException;

public interface CompanyService {
    CommonResponseDto saveCompany(RequestRegistryDto dto);
    PaginatedResponseCompanyDto allCompany() throws SQLException;
    CommonResponseDto updateCompany(RequestRegistryDto dto, String companyId);
}
