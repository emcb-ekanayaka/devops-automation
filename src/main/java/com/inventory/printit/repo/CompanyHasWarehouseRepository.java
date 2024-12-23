package com.inventory.printit.repo;

import com.inventory.printit.entity.CompanyHasWarehouse;
import com.inventory.printit.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyHasWarehouseRepository extends JpaRepository<CompanyHasWarehouse, String> {

    @Query(value = "SELECT * FROM student_has_course WHERE company_id=?1 AND warehouse_id=?2", nativeQuery = true)
    Optional<CompanyHasWarehouse> findCompanyAndWarehouse(String companyId, String warehouseId);

}