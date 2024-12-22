package com.inventory.printit.service;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;

public interface CompanyService {
    CommonResponseDto saveCompany(RequestRegistryDto dto);
}
