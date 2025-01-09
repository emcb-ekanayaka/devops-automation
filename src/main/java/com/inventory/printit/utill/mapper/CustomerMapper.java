package com.inventory.printit.utill.mapper;

import com.inventory.printit.dto.CustomerDto;
import com.inventory.printit.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer dtoToCustomerEntity(CustomerDto customerDto);
    CustomerDto toCustomerDto(Customer customer);
}
