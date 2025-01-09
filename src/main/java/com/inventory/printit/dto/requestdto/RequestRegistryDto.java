package com.inventory.printit.dto.requestdto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RequestRegistryDto {

    private String companyName;
    private String comAddressOne;
    private String comAddressTwo;
    private String comAddressThree;
    private String brNumber;

    private String warehouseName;
    private String warehouseLocation;

    private String firstName;
    private String lastName;
    private String address;
}
