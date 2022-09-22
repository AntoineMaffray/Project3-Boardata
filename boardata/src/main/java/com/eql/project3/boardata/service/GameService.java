package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Game;

import java.util.List;

public interface GameService {

    void saveGame(Game game);

    List<Game> findAllGames();
}
