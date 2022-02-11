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

    @NotNull(message = "Payment date can not be null")
    private Date payment_date;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="payment_amount",referencedColumnName = "payment")
    private Flat payment;








}
