package com.inventory.printit.dto.responsedto.paginated;

import com.inventory.printit.dto.responsedto.CompanyResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseCompanyDto {
    private Long count;
    private List<CompanyResponseDto> dataList;
}
