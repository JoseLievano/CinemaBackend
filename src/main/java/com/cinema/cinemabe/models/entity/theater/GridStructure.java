package com.cinema.cinemabe.models.entity.theater;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GridStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "rows", nullable = false)
    private Integer rows;

    @Column (name = "columns", nullable = false)
    private Integer columns;

    @Column (name = "bluePrint", nullable = false)
    private String bluePrint;

    @OneToMany(mappedBy = "gridStructure")
    private List<Theater> theaters;


}
