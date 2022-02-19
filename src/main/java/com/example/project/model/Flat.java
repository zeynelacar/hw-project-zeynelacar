package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Integer flatId;


    @NotNull
    private Integer flat_number;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "block_id",referencedColumnName = "id")
    @JsonIgnoreProperties({"name"})
    private Block id;

}


