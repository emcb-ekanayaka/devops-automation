package com.inventory.printit.service.impl;

import com.inventory.printit.dto.WarehouseDto;
import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.entity.Company;
import com.inventory.printit.entity.Warehouse;
import com.inventory.printit.exception.EntryNotFoundException;
import com.inventory.printit.repo.WarehouseRepository;
import com.inventory.printit.service.WarehouseService;
import com.inventory.printit.utill.Generator;
import com.inventory.printit.utill.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private Generator generator;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private WarehouseRepository warehouseRepo;

    @Override
    public CommonResponseDto saveWarehouse(RequestRegistryDto dto) {
        System.out.println(dto);
        try {
            String warehouseCode = "WH-C" + "-" + generator.generateFourNumbers();
            String whrId =  generator.generateFourNumbers();
            WarehouseDto warehouseDto = new WarehouseDto(
                    whrId,
                    warehouseCode,
                    dto.getWarehouseName(),
                    dto.getWarehouseLocation()
            );
            warehouseRepo.save(warehouseMapper.dtoToWarehouseEntity(warehouseDto));

            return new CommonResponseDto(201, "Warehouse  saved!", warehouseDto.getWarehouseCode(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateWarehouse(RequestRegistryDto dto, String warehouseId) {
        try {
            Warehouse warehouseObj = warehouseRepo.getById(warehouseId);
            warehouseObj.setWarehouseName(dto.getWarehouseName());
            warehouseObj.setWarehouseLocation(dto.getWarehouseLocation());

            warehouseRepo.save(warehouseObj);
            return new CommonResponseDto(201, "Warehouse  Updated!", warehouseObj.getWarehouseCode(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeWarehouse(String warehouseId) {
        Optional<Warehouse> warehouse = warehouseRepo.findById(warehouseId);
        if (warehouse.isPresent()) {
            warehouseRepo.delete(warehouse.get());
            return new CommonResponseDto(201, "Warehouse was deleted!", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Warehouse...!");
        }
    }
}
