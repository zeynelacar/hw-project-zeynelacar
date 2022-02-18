package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fees")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer electricity_bill;

    @NotNull
    private Integer gas_bill;

    @NotNull
    private Integer water_bill;

    @NotNull
    private Integer dues;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @Transient
    public Integer totalFee;

    public Integer getTotalFee(){

        totalFee = water_bill + gas_bill + water_bill + dues;
        return totalFee;

    }




}
