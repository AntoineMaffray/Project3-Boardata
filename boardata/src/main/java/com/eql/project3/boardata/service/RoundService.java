package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Round;

import java.util.List;

public interface RoundService {

    void saveRound(Round round);

    List<Round> findAllRounds();

    Round findRoundByID(Long id);
}
