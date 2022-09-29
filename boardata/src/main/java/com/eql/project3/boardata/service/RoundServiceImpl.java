package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Round;
import com.eql.project3.boardata.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    RoundRepository roundRepository;

    @Override
    public void saveRound(Round round) {
        System.out.println(round.getGame().getName());
        System.out.println(round.getMatchDate());
        roundRepository.save(round);
    }

    @Override
    public List<Round> findAllRounds() {
        return roundRepository.findAll();
    }

    @Override
    public Round findRoundByID(Long id) {
        Optional<Round> optional = roundRepository.findById(id);
        Round round = null;

        if (optional.isPresent()){
            round = optional.get();
        } else {
            throw new RuntimeException("Round not found for id : " + id);
        }
        return round;
    }
}
