package com.cinema.cinemabe.models.entity.theater;

import com.cinema.cinemabe.models.entity.movie.ShowTime;
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
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private TheaterType theaterType;

    @ManyToOne
    private GridStructure gridStructure;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "theater_id")
    private List<ShowTime> showTimes;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Zone> zones;

    public void addZone(Zone zone){
        this.zones.add(zone);
    }

    public void removeZone (Zone zone){
        this.zones.remove(zone);
    }

    public void flushZones (){
        this.zones.forEach(zone -> zone.removeTheater());
        this.zones.clear();
    }

}
