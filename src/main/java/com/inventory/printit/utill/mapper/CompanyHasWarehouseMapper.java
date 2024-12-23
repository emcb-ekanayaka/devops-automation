package com.inventory.printit.utill.mapper;

import com.inventory.printit.dto.CompanyHasWarehouseDto;
import com.inventory.printit.entity.CompanyHasWarehouse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface CompanyHasWarehouseMapper {
    CompanyHasWarehouse dtoToCompanyHasWarehouseEntity(CompanyHasWarehouseDto companyHasWarehouseDto);
}
