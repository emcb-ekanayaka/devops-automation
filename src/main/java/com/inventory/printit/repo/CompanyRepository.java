package com.inventory.printit.repo;

import com.inventory.printit.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    @Query(value = "SELECT * FROM company WHERE id=:companyId", nativeQuery = true)
    List<Company> getCompany(@Param("companyId") String companyId);
}
