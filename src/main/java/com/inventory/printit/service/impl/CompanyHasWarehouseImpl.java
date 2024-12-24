package com.inventory.printit.service.impl;

import com.inventory.printit.dto.CompanyHasWarehouseDto;
import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.entity.Company;
import com.inventory.printit.entity.CompanyHasWarehouse;
import com.inventory.printit.entity.Warehouse;
import com.inventory.printit.exception.EntryNotFoundException;
import com.inventory.printit.repo.CompanyHasWarehouseRepository;
import com.inventory.printit.repo.CompanyRepository;
import com.inventory.printit.repo.WarehouseRepository;
import com.inventory.printit.service.CompanyHasWarehouseService;
import com.inventory.printit.utill.mapper.CompanyHasWarehouseMapper;
import com.inventory.printit.utill.mapper.CompanyMapper;
import com.inventory.printit.utill.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class CompanyHasWarehouseImpl implements CompanyHasWarehouseService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private CompanyHasWarehouseMapper companyHasWarehouseMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private CompanyHasWarehouseRepository companyHasWarehouseRepository;



    @Override
    public CommonResponseDto saveCompanyHasWarehouse(RequestRegistryDto dto) {

        Optional<Company> company = companyRepository.findCompanyByName(dto.getCompanyName());
        Optional<Warehouse> warehouse = warehouseRepository.findWarehouseByName(dto.getWarehouseName());
        System.out.println(company.get().getId());
        System.out.println(warehouse.get().getId());
        Optional<CompanyHasWarehouse> companyAndWarehouse = companyHasWarehouseRepository.findCompanyAndWarehouse(company.get().getId(),warehouse.get().getId());

        if (company.isPresent() && warehouse.isPresent() && !companyAndWarehouse.isPresent()){

            try {
                CompanyHasWarehouseDto companyHasWarehouseDto = new CompanyHasWarehouseDto(
                        companyMapper.toCompanyDto(company.get()),
                        warehouseMapper.toCompanyDto(warehouse.get())
                );

                companyHasWarehouseRepository.save(companyHasWarehouseMapper.dtoToCompanyHasWarehouseEntity(companyHasWarehouseDto));

                return new CommonResponseDto(201, "Company Warehouse  saved!", companyHasWarehouseDto, new ArrayList<>());
            }catch (Exception e){
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }

        }else {
            return new CommonResponseDto(400, "Student - Course  Not Found! or already exist",0, new ArrayList<>());
        }
    }

    @Override
    public CommonResponseDto updateCompanyHasWarehouse(RequestRegistryDto dto, Integer companyHasWarehouseId) {
        try {

            CompanyHasWarehouse companyHasWarehouseObj = companyHasWarehouseRepository.findByComWHRID(companyHasWarehouseId);
            Optional<Company> student = companyRepository.findCompanyByName(dto.getCompanyName());
            Optional<Warehouse> course = warehouseRepository.findWarehouseByName(dto.getWarehouseName());

            companyHasWarehouseObj.setCompanyId(student.get());
            companyHasWarehouseObj.setWarehouseId(course.get());

            companyHasWarehouseRepository.save(companyHasWarehouseObj);

            return new CommonResponseDto(201, "Company - Warehouse Updated!", companyHasWarehouseObj.getId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeCompanyHasWarehouse(Integer companyHasWarehouseId) {
        Optional<CompanyHasWarehouse> companyHasWarehouse = companyHasWarehouseRepository.findById(companyHasWarehouseId);

        if (companyHasWarehouse.isPresent()) {
            companyHasWarehouseRepository.delete(companyHasWarehouse.get());
            return new CommonResponseDto(201, "Company - Warehouse was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Company - Warehouse...!");
        }
    }
}
