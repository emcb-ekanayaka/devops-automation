package com.inventory.printit.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String address;
}
