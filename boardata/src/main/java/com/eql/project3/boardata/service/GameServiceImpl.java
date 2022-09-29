package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Game;
import com.eql.project3.boardata.models.User;
import com.eql.project3.boardata.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game findGameByID(Long id) {
        Optional<Game> optional = gameRepository.findById(id);
        Game game = null;

        if (optional.isPresent()){
            game = optional.get();
        } else {
            throw new RuntimeException("Game not found for id : " + id);
        }
        return game;
    }
}
