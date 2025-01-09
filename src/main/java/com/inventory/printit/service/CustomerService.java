package com.inventory.printit.service;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseCompanyDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseCustomerDto;

import java.sql.SQLException;

public interface CustomerService {

    CommonResponseDto saveCustomer(RequestRegistryDto dto);
    CommonResponseDto removeCustomer(String customerId);
    CommonResponseDto updateCustomer(RequestRegistryDto dto, String customerId);
    PaginatedResponseCustomerDto allCustomers() throws SQLException;
}
