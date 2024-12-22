package com.inventory.printit.dto.requestdto;
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
}
