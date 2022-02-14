package com.example.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Flat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flat_id;


    @NotNull
    private Integer flat_number;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    private Block id;

}


