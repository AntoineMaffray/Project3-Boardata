package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Game;
import com.eql.project3.boardata.models.Nature;
import com.eql.project3.boardata.repository.NatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureServiceImpl implements NatureService {

    @Autowired
    NatureRepository natureRepository;


    @Override
    public void saveNature(Nature nature) {
        natureRepository.save(nature);
    }

    @Override
    public List<Nature> findAllNatures() {
        return natureRepository.findAll();
    }
}
