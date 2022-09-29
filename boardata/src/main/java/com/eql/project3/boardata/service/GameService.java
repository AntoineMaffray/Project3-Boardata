package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Game;
import com.eql.project3.boardata.models.User;

import java.util.List;

public interface GameService {

    void saveGame(Game game);

    List<Game> findAllGames();

    Game findGameByID (Long id);

}
