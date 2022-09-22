package com.eql.project3.boardata.models;

import javax.persistence.*;

@Entity
@Table(name = "nature")
public class Nature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long natureId;

    private String civilian;

    private String war;

    private String science;

    private String business;

    private String guilds;

    private String money;

    private String wonder;

    private String agora;

    private String cities;

    @OneToOne (mappedBy = "nature")
    private Result result;
}
