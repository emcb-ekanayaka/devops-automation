package com.inventory.printit.service.impl;

import com.inventory.printit.dto.CompanyDto;
import com.inventory.printit.dto.CustomerDto;
import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.dto.responsedto.CompanyResponseDto;
import com.inventory.printit.dto.responsedto.CustomerResponseDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseCompanyDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseCustomerDto;
import com.inventory.printit.entity.Company;
import com.inventory.printit.entity.CompanyHasWarehouse;
import com.inventory.printit.entity.Customer;
import com.inventory.printit.entity.Warehouse;
import com.inventory.printit.exception.EntryNotFoundException;
import com.inventory.printit.repo.CompanyHasWarehouseRepository;
import com.inventory.printit.repo.CompanyRepository;
import com.inventory.printit.repo.CustomerRepository;
import com.inventory.printit.service.CustomerService;
import com.inventory.printit.utill.Generator;
import com.inventory.printit.utill.mapper.CompanyMapper;
import com.inventory.printit.utill.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private Generator generator;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CommonResponseDto saveCustomer(RequestRegistryDto dto) {

        if (true){
            try {
                String cusId =  generator.generateFourNumbers();
                CustomerDto customerDto = new CustomerDto(
                        cusId,
                        dto.getFirstName(),
                        dto.getLastName(),
                        dto.getAddress()
                );
                customerRepository.save(customerMapper.dtoToCustomerEntity(customerDto));

                return new CommonResponseDto(201, "Customer  saved!", customerDto.getId(), new ArrayList<>());
            }catch (Exception e){
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        }else {
            return new CommonResponseDto(400, "Customer Not Found! or already exist",0, new ArrayList<>());
        }
    }

    @Override
    public CommonResponseDto removeCustomer(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
            return new CommonResponseDto(201, "Customer was deleted!", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Warehouse...!");
        }
    }

    @Override
    public CommonResponseDto updateCustomer(RequestRegistryDto dto, String customerId) {
        try {
            Customer customerObj = customerRepository.getById(customerId);
            customerObj.setFirstName(dto.getFirstName());
            customerObj.setLastName(dto.getLastName());
            customerObj.setAddress(dto.getAddress());
            customerRepository.save(customerObj);
            return new CommonResponseDto(201, "Customer  Updated!", customerObj.getId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public PaginatedResponseCustomerDto allCustomers() throws SQLException {
        try {
            List<Customer> allCustomerForProvidedId = customerRepository.findAll();
            List<CustomerResponseDto> customerResponseDto = new ArrayList<>();

            for (Customer c : allCustomerForProvidedId) {
                customerResponseDto.add(
                        new CustomerResponseDto(
                                c.getId(),
                                c.getFirstName(),
                                c.getLastName(),
                                c.getAddress()
                        )
                );
            }
            return new PaginatedResponseCustomerDto(
                    customerRepository.count(),
                    customerResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
