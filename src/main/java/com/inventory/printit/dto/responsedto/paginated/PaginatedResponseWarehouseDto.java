package com.inventory.printit.dto.responsedto.paginated;
import com.inventory.printit.dto.responsedto.WarehouseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseWarehouseDto {
    private Long count;
    private List<WarehouseResponseDto> dataList;
}
