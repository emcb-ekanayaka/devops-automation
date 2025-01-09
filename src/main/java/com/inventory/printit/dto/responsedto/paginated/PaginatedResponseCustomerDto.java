package com.inventory.printit.dto.responsedto.paginated;

import com.inventory.printit.dto.responsedto.CustomerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseCustomerDto {

    private Long count;
    private List<CustomerResponseDto> dataList;
}
