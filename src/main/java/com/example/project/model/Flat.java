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
@Table(name = "blocks")
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


