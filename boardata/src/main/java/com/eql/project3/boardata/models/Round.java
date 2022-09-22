package com.eql.project3.boardata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "round")
@Getter
@Setter
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date matchDate;

    @OneToMany(mappedBy = "round")
    private List<Result> results = new ArrayList<>();

    @OneToOne
    @JoinColumn (name = "Game_id", referencedColumnName = "gameId")
    private Game game;

}
