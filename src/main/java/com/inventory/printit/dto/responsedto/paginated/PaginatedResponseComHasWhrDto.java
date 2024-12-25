package com.inventory.printit.dto.responsedto.paginated;

import com.inventory.printit.dto.responsedto.CompanyHasWarehouseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseComHasWhrDto {
    private Long count;
    private List<CompanyHasWarehouseResponseDto> dataList;
}
