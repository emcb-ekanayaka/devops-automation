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
@Table(name = "company")
public class Company {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="companycode")
    private String companyCode;

    @Column(name="companyname")
    private String companyName;

    @Column(name="comaddressone")
    private String comAddressOne;

    @Column(name="comaddresstwo")
    private String comAddressTwo;

    @Column(name="comaddressthree")
    private String comAddressThree;

    @Column(name="brnumber")
    private String brNumber;

    @OneToMany(mappedBy = "companyId", cascade = CascadeType.ALL)
    private List<CompanyHasWarehouse> companyHasWarehouses;
}
