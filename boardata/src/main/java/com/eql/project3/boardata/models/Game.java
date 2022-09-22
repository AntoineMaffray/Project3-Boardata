package com.eql.project3.boardata.models;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String name;

    private boolean typeCalc;

    @OneToOne(mappedBy = "game")
    private Round round;
}
