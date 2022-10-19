package com.eql.project3.boardata.service;


import com.eql.project3.boardata.models.*;
import com.eql.project3.boardata.repository.GameRepository;
import com.eql.project3.boardata.repository.RoleRepository;
import com.eql.project3.boardata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");

        if (role == null) {
            role = checkRoleExist();
        }

        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.matches("1", "2a$10$BFwCOIynlxC/DOdP1i/vrOZcSJEGZkhrurO7uijU0Ksu55iX3duh6"));

    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByID(Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;

        if (optional.isPresent()){
            user = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id : " + id);
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {

        return  userRepository.findAll();
//
//        List<User> users = userRepository.findAll();
//
//        return users.stream().collect(Collectors.toList());

//        return new ArrayList<>(users);
    }

    @Override
    public List<User> findMyFriends() {
        return null;
    }

    @Override
    public List<Final> getData(User user) {
        List<Final> datas = new ArrayList<>();

        Final swfinal = new Final();
        swfinal.setGameName("Seven Wonders");
        Final adrfinal = new Final();
        adrfinal.setGameName("Les aventuriers du rail");
        Final cdfinal = new Final();
        cdfinal.setGameName("Code names");
        Final sqpfinal = new Final();
        sqpfinal.setGameName("Six qui prend");

        List<Result> swresults = new ArrayList<>();
        List<Result> adrresults = new ArrayList<>();
        List<Result> cdresults = new ArrayList<>();
        List<Result> sqpresults = new ArrayList<>();


        for (Result result : user.getResults()) {
            if (result.getRound().getGame().getName().equals("7 wonders")) {
                swresults.add(result);
            } else if (result.getRound().getGame().getName().equals("Les aventuriers du rail")) {
                adrresults.add(result);
            } else if (result.getRound().getGame().getName().equals("Code names")) {
                cdresults.add(result);
            } else if (result.getRound().getGame().getName().equals("Six qui prend")) {
                sqpresults.add(result);
            }
        }

        swfinal.setParticipation(swresults.size());
        adrfinal.setParticipation(adrresults.size());
        cdfinal.setParticipation(cdresults.size());
        sqpfinal.setParticipation(sqpresults.size());

        List<Result> swresultsw = new ArrayList<>();
        List<Result> adrresultsw = new ArrayList<>();
        List<Result> cdresultsw = new ArrayList<>();
        List<Result> sqpresultsw = new ArrayList<>();

        for (Result swresult : swresults) {
            if (swresult.isWin()) {
                swresultsw.add(swresult);
            }
        }
        for (Result adrresult : adrresults) {
            if (adrresult.isWin()) {
                adrresultsw.add(adrresult);
            }
        }
        for (Result cdresult : cdresults) {
            if (cdresult.isWin()) {
                cdresultsw.add(cdresult);
            }
        }
        for (Result sqpresult : sqpresults) {
            if (sqpresult.isWin()) {
                sqpresultsw.add(sqpresult);
            }
        }

        swfinal.setWin(swresultsw.size());
        swfinal.setPercentage(Math.round(swfinal.getWin()/swfinal.getParticipation()*100));
        datas.add(swfinal);

        adrfinal.setWin(adrresultsw.size());
        adrfinal.setPercentage(Math.round(adrfinal.getWin()/adrfinal.getParticipation()*100));
        datas.add(adrfinal);

        cdfinal.setWin(cdresultsw.size());
        cdfinal.setPercentage(Math.round(cdfinal.getWin()/cdfinal.getParticipation())*100);
        datas.add(cdfinal);

        sqpfinal.setWin(sqpresultsw.size());
        sqpfinal.setPercentage(Math.round(sqpfinal.getWin()/sqpfinal.getParticipation())*100);
        datas.add(sqpfinal);

        return datas;
    }


    @Override
    public List<Final> getAllData(User user) {
        List<Final> datas = new ArrayList<>();

        List<Game> playedGames = new ArrayList<>();

        List<Game> allGames = gameRepository.findAll();

        for (Game allGame : allGames) {
            boolean didHePlayed=false;
            for (Result result : user.getResults()) {
                if (result.getRound().getGame().getName().equals(allGame.getName())) {
                    didHePlayed=true;
                    break;
                }
            }
            if (didHePlayed) {
                playedGames.add(allGame);
            }
        }


        for (Game allGame : allGames) {
            Final aFinal = new Final();
            aFinal.setGameName(allGame.getName());
            datas.add(aFinal);
        }

        List<List<Result>> allResults = new ArrayList<>();

        for (Game allGame : allGames) {
            List<Result> gameResult = new ArrayList<>();
            for (Result result : user.getResults()) {
                if (result.getRound().getGame().getName().equals(allGame.getName())) {
                    gameResult.add(result);
                }
            }
            allResults.add(gameResult);
        }

        for (int i = 0; i < datas.size(); i++) {
            datas.get(i).setParticipation(allResults.get(i).size());
        }

        allResults = new ArrayList<>();

        for (Game allGame : allGames) {
            List<Result> gameResult = new ArrayList<>();
            for (Result result : user.getResults()) {
                if (result.getRound().getGame().getName().equals(allGame.getName()) && result.isWin()) {
                    gameResult.add(result);
                }
            }
            allResults.add(gameResult);
        }

        for (int i = 0; i < datas.size(); i++) {
            datas.get(i).setWin(allResults.get(i).size());
        }

        for (Final data : datas) {
            data.setPercentage(Math.round(data.getWin()/data.getParticipation())*100);
        }

        return datas;
    }


    @Override
    public List<Final> getFinalAllData(User user) {

        List<Final> datas = new ArrayList<>();

        List<Game> playedGames = new ArrayList<>();

        List<Game> allGames = gameRepository.findAll();

        for (Game allGame : allGames) {
            boolean didHePlayed=false;
            for (Result result : user.getResults()) {
                if (result.getRound().getGame().getName().equals(allGame.getName())) {
                    didHePlayed=true;
                    break;
                }
            }
            if (didHePlayed) {
                playedGames.add(allGame);
            }
        }


        for (Game playedGame : playedGames) {
            Final aFinal = new Final();
            aFinal.setGameName(playedGame.getName());
            datas.add(aFinal);
        }

        List<List<Result>> allResults = new ArrayList<>();

        for (Game playedGame : playedGames) {
            List<Result> gameResult = new ArrayList<>();
            for (Result result : user.getResults()) {
                if (result.getRound().getGame().getName().equals(playedGame.getName())) {
                    gameResult.add(result);
                }
            }
            allResults.add(gameResult);
        }

        for (int i = 0; i < datas.size(); i++) {
            datas.get(i).setParticipation(allResults.get(i).size());
        }

        allResults = new ArrayList<>();

        for (Game playedGame : playedGames) {
            List<Result> gameResult = new ArrayList<>();
            for (Result result : user.getResults()) {
                if (result.getRound().getGame().getName().equals(playedGame.getName()) && result.isWin()) {
                    gameResult.add(result);
                }
            }
            allResults.add(gameResult);
        }

        for (int i = 0; i < datas.size(); i++) {
            datas.get(i).setWin(allResults.get(i).size());
        }

        for (Final data : datas) {
            double percentage = (100.0*data.getWin())/data.getParticipation();
            percentage = Math.round(percentage);
            data.setPercentage(percentage);
        }

        return datas;
    }

}

