package com.inventory.printit.controller;
import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.service.WarehouseService;
import com.inventory.printit.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedWarehouse(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = warehouseService.saveWarehouse(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{warehouseId}")
    public ResponseEntity<StandardResponse> updateWarehouse(@RequestBody RequestRegistryDto data, @PathVariable String warehouseId){
        CommonResponseDto responseData = warehouseService.updateWarehouse(data,warehouseId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{warehouseId}")
    public ResponseEntity<StandardResponse> deleteCompany(@PathVariable String warehouseId){
        CommonResponseDto responseData = warehouseService.removeWarehouse(warehouseId);
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
    public ResponseEntity<StandardResponse> getAllWarehouse()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Warehouse List",
                        warehouseService.allWarehouses()),
                HttpStatus.OK
        );
    }
}
