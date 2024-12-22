package com.inventory.printit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

}
