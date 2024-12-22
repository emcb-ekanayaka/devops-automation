package com.inventory.printit.utill.mapper;

import com.inventory.printit.dto.CompanyDto;
import com.inventory.printit.entity.Company;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company dtoToCompanyEntity(CompanyDto companyDto);
}
