package com.eql.project3.boardata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "nature")
public class Nature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long natureId;

    private int civilian;

    private int war;

    private int science;

    private int business;

    private int guilds;

    private int money;

    private int wonder;

    private int agora;

    private int cities;

    @OneToOne (mappedBy = "nature")
    private Result result;
}
