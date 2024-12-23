package com.inventory.printit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "student_has_course")
public class CompanyHasWarehouse {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="company_id", referencedColumnName = "id")
    private Company companyId;

    @ManyToOne
    @JoinColumn(name="warehouse_id", referencedColumnName = "id")
    private Warehouse warehouseId;
}
