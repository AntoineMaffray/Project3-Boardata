package com.eql.project3.boardata.controller;

import com.eql.project3.boardata.models.*;
import com.eql.project3.boardata.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    GameService gameService;

    @Autowired
    UserService userService;

    @Autowired
    RoundService roundService;

    @Autowired
    ResultService resultService;

    @Autowired
    NatureService natureService;

    @Autowired
    FriendshipService friendshipService;

    Round currentRound;

    Game currentGame;

    Result currentResult;



    @GetMapping("/chooseGame")
    public String showGames(Model model) {
        // Appel du service
        List<Game> games = gameService.findAllGames();
        // Stockage
        model.addAttribute("games", games);
        // Redirection vers page
        currentRound = null;
        return "chooseGame";
    }


    @GetMapping("/showNewGameForm")
    public String showNewGameForm(Model model){
        Game game = new Game();
        model.addAttribute("game", game);
        return "addGame";
    }


    @PostMapping("/saveGame")
    public String saveGame(@ModelAttribute("game") Game game) {
        gameService.saveGame(game);
        return "redirect:/chooseGame";
    }


    @GetMapping("/addRound/{id}")
    public String addRound(@PathVariable(value = "id") Long id){
        currentGame = gameService.findGameByID(id);
        if (currentRound == null) {
            Round round = new Round();
            round.setGame(currentGame);
            round.setMatchDate(LocalDate.now());
            roundService.saveRound(round);
            currentRound = round;
        }
        return "redirect:/addPlayers";
    }


    @GetMapping("/addPlayers")
    public String choosePlayers(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        List<User> players = friendshipService.findMyFriends(connectedUser);
        if (players.isEmpty()) {
            return "dontHaveFriends";
        } else {
            players.add(connectedUser);
            model.addAttribute("players", players);
            return "addPlayers";
        }
    }


    @GetMapping("/addPlayer/{id}")
    public String addPlayers(@PathVariable(value = "id") Long idU, Model model){
        String path  = "";
        Result result = new Result();
        result.setRound(currentRound);
        result.setUser(userService.findUserByID(idU));
        currentRound.getResults().add(result);
        roundService.saveRound(currentRound);
        resultService.saveResult(result);
        currentResult = result;
        System.out.println("on va jusque là");
        model.addAttribute("result", result);
        if (currentRound.getGame().getGameId() == 1) {
            path = "showNewResultSWForm";
        } else {
            path = "showNewResultRGForm";
        }
        return "redirect:/"+path;
    }


    @GetMapping("/showNewResultSWForm")
    public String showNewResultSWForm(Model model){
        Nature nature = new Nature();
        model.addAttribute("nature", nature);
        return "fillSevenWondersPlayerScore";
    }


    @PostMapping("/saveNature")
    public String saveResultSW(@ModelAttribute("nature") Nature nature) {
        natureService.saveNature(nature);
        currentResult.setNature(nature);
        currentResult.setScore(nature.getWonder()
                + nature.getCivilian()
                + nature.getWar()
                + nature.getScience()
                + nature.getBusiness()
                + nature.getGuilds()
                + nature.getMoney()
                + nature.getAgora()
                + nature.getCities()
        );
        resultService.saveResult(currentResult);
        return "redirect:/showNewResultSWForm?success";
    }

    @GetMapping("/showNewResultRGForm")
    public String showNewResultRGForm(Model model){
        model.addAttribute("result", currentResult);
        return "fillRegularGamePlayerScore";
    }

    @PostMapping("/saveSimpleScore")
    public String saveResultRG(@ModelAttribute("result") Result result) {
        currentResult.setScore(result.getScore());
        resultService.saveResult(currentResult);
        return "redirect:/showNewResultRGForm?success";
    }

    @GetMapping("/showResult")
    public String showResult (Model model) {
        List<Result> results = currentRound.getResults();
        List<Result> winnerResults = new ArrayList<>();
        Result winnerResult = new Result();
        winnerResult.setScore(0);
        for (Result result : results) {
            if (result.getScore() > winnerResult.getScore()) {
                winnerResult = result;
            }
        }
        for (Result result : results) {
            if (result.getScore() == winnerResult.getScore()) {
                winnerResults.add(result);
            }
        }
        for (Result result : winnerResults) {
            result.setWin(true);
            resultService.saveResult(result);
        }
        model.addAttribute("results", results);
        return "showResult";
    }
}

