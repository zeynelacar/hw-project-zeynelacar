package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fees")
public class Fee implements Serializable {

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


    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "flat_id",referencedColumnName = "flatId",nullable = false)
    @JsonIgnoreProperties({"flat_number","id"})
    private Flat flat_id;

    @Transient
    public Integer totalFee;

    public Integer getTotalFee(){

        totalFee = water_bill + gas_bill + water_bill + dues;
        return totalFee;

    }




}
