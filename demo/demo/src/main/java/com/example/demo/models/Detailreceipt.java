package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="detailreceipt")
public class Detailreceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetailreceipt;
    public Integer idreceipt;
    public String idproduct;
    public double amount;
    public double unitprice;
    public double totalprice;
}
