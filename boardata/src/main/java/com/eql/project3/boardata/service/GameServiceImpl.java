package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Game;
import com.eql.project3.boardata.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public void saveGame(Game game) {

    }

    @Override
    public List<Game> findAllGames() {
        return null;
    }
}
