package com.inventory.printit.service;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseCompanyDto;

import java.sql.SQLException;

public interface CompanyService {
    CommonResponseDto saveCompany(RequestRegistryDto dto);
    CommonResponseDto updateCompany(RequestRegistryDto dto, String companyId);
    CommonResponseDto removeCompany(String companyId);
    PaginatedResponseCompanyDto allCompany() throws SQLException;
    PaginatedResponseCompanyDto companyById(String companyId) throws SQLException;
}
