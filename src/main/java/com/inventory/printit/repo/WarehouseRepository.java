package com.inventory.printit.repo;
import com.inventory.printit.entity.Company;
import com.inventory.printit.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
    @Query(value = "SELECT * FROM warehouse WHERE id=:warehouseCode", nativeQuery = true)
    List<Warehouse> getWarehouse(@Param("warehouseCode") String warehouseCode);

    @Query(value = "SELECT * FROM warehouse WHERE warehousename=:warehouseName", nativeQuery = true)
    Optional<Warehouse> findWarehouseByName(@Param("warehouseName") String warehouseName);
}
