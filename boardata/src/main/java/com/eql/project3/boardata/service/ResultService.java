package com.eql.project3.boardata.service;


import com.eql.project3.boardata.models.Result;

import java.util.List;

public interface ResultService {

    void saveResult (Result result);

    List<Result> findAllResults();

    Result findResultByID(Long id);
}
