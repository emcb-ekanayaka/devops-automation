package com.inventory.printit.repo;

import com.inventory.printit.entity.CompanyHasWarehouse;
import com.inventory.printit.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyHasWarehouseRepository extends JpaRepository<CompanyHasWarehouse, Integer> {

    @Query(value = "SELECT * FROM company_has_warehouse WHERE company_id=?1 AND warehouse_id=?2", nativeQuery = true)
    Optional<CompanyHasWarehouse> findCompanyAndWarehouse(String companyId, String warehouseId);

    @Query(value = "SELECT * FROM company_has_warehouse WHERE id=?1", nativeQuery = true)
    CompanyHasWarehouse findByComWHRID(Integer companyHasWarehouseId);

    @Query(value = "SELECT * FROM company_has_warehouse WHERE id=?1", nativeQuery = true)
    List<CompanyHasWarehouse> findByCW(Integer companyHasWarehouseId);

    @Query(value = "SELECT * FROM company_has_warehouse WHERE company_id=:companyId", nativeQuery = true)
    List<CompanyHasWarehouse> getCompany(@Param("companyId") String companyId);

    @Query(value = "SELECT * FROM company_has_warehouse WHERE warehouse_id=:warehouseId", nativeQuery = true)
    List<CompanyHasWarehouse> getWarehouse(@Param("warehouseId") String warehouseId);

}
