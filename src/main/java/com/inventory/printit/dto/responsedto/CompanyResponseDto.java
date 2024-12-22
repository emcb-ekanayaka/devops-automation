package com.inventory.printit.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDto {
    private String id;
    private String companyCode;
    private String companyName;
    private String comAddressOne;
    private String comAddressTwo;
    private String comAddressThree;
    private String brNumber;
}
