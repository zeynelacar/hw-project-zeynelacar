package com.example.project.model;



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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message= "Electricity bill can not be null")
    private Integer electricity_bill;

    @NotNull(message = "Water bill can not be null")
    private Integer water_bill;

    @NotNull(message = "Gas bill can not be null")
    private Integer gas_bill;

    @NotNull(message = "Due value can not be null")
    private Integer dues;


    @Column(name="flat_debt")
    private Integer flat_debt;


    @NotNull(message = "Receivable value can not be null")
    private Integer receivable;

    @Column(name="total_fee")
    private Integer total_fee;


}
