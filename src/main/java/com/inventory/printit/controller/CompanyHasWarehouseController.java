package com.inventory.printit.controller;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.service.CompanyHasWarehouseService;
import com.inventory.printit.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/companyhaswarehouse")
public class CompanyHasWarehouseController {


    @Autowired
    private CompanyHasWarehouseService companyHasWarehouseService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedStudentHasCourse(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = companyHasWarehouseService.saveCompanyHasWarehouse(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{companyHasWarehouseId}")
    public ResponseEntity<StandardResponse> updateCompanyHasWarehouse(@RequestBody RequestRegistryDto data, @PathVariable Integer companyHasWarehouseId){
        CommonResponseDto responseData = companyHasWarehouseService.updateCompanyHasWarehouse(data,companyHasWarehouseId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }
}
