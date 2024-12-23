package com.inventory.printit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="warehousecode")
    private String warehouseCode;

    @Column(name="warehousename")
    private String warehouseName;

    @Column(name="warehouselocation")
    private String warehouseLocation;

    @OneToMany(mappedBy = "warehouseId", cascade = CascadeType.ALL)
    private List<CompanyHasWarehouse> companyHasWarehouses;

}
