package com.inventory.printit.controller;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.service.CompanyHasWarehouseService;
import com.inventory.printit.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

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

    @DeleteMapping("{companyHasWarehouseId}")
    public ResponseEntity<StandardResponse> deleteCompanyHasWarehouse(@PathVariable Integer companyHasWarehouseId){
        CommonResponseDto responseData = companyHasWarehouseService.removeCompanyHasWarehouse(companyHasWarehouseId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCompanyHasWarehouse()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Company has warehouse List",
                        companyHasWarehouseService.allCompanyHasWarehouses()),
                HttpStatus.OK
        );
    }

    @GetMapping("{companyHasWarehouseId}")
    public ResponseEntity<StandardResponse> getStudentHasCourse(@PathVariable Integer companyHasWarehouseId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Company has warehouse Details",
                        companyHasWarehouseService.companyHasWarehouseById(companyHasWarehouseId)),
                HttpStatus.OK
        );
    }
}
