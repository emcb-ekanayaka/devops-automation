package com.inventory.printit.controller;

import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.service.CompanyService;
import com.inventory.printit.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedCompany(@RequestBody RequestRegistryDto data){
        System.out.println(data);
        CommonResponseDto responseData = companyService.saveCompany(data);
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
    public ResponseEntity<StandardResponse> getAllCourse()throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Company List",
                        companyService.allCompany()),
                HttpStatus.OK
        );
    }
}
