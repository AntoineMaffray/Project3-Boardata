package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Result;
import com.eql.project3.boardata.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService{

    @Autowired
    ResultRepository resultRepository;

    @Override
    public void saveResult(Result result) {
        resultRepository.save(result);
    }

    @Override
    public List<Result> findAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public Result findResultByID(Long id) {
        Optional<Result> optional = resultRepository.findById(id);
        Result result = null;

        if (optional.isPresent()){
            result = optional.get();
        } else {
            throw new RuntimeException("Result not found for id : " + id);
        }
        return result;
    }
}

