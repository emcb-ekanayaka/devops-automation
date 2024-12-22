package com.inventory.printit.utill.mapper;
import com.inventory.printit.dto.WarehouseDto;
import com.inventory.printit.entity.Warehouse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    Warehouse dtoToWarehouseEntity(WarehouseDto warehouseDto);
}
