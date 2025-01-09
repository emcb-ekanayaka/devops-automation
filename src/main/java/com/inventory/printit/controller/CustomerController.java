package com.inventory.printit.controller;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.service.CompanyService;
import com.inventory.printit.service.CustomerService;
import com.inventory.printit.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedCompany(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = customerService.saveCustomer(data);
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
    public ResponseEntity<StandardResponse> getCompany()throws SQLException {

        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Customer List",
                        customerService.allCustomers()),
                HttpStatus.OK
        );
    }

    @PutMapping("{customerId}")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody RequestRegistryDto data, @PathVariable String customerId){
        CommonResponseDto responseData = customerService.updateCustomer(data,customerId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable String customerId){
        CommonResponseDto responseData = customerService.removeCustomer(customerId);
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
