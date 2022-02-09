package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="block_name",referencedColumnName = "name")
    private Block name;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="flat_number",referencedColumnName = "flat_number")
    private Flat flat_number;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="total_fee",referencedColumnName = "total_fee")
    private Fee total_fee;

    @NotNull(message = "Payment date can not be null")
    private Date payment_date;




}
