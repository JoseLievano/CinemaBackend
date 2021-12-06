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
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String name;

    @Column(nullable = false)
    private Boolean isASeat;

    @ManyToMany(mappedBy = "zones")
    private List<ShowTime> showTimes;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @PreRemove
    public void removeTheater(){
        this.theater.removeZone(this);
        this.theater = null;
    }

}
