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
@Table(name = "flats")

public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "flat number can not be null")
    private Integer flat_number;

    @NotNull
    private Integer payment;

    @NotNull(message = "Debt value can not be null")
    private Integer debt;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="block_name",referencedColumnName = "name")
    private Block name;




}
