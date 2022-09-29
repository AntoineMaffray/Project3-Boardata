package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Nature;

import java.util.List;

public interface NatureService {

    void saveNature(Nature nature);

    List<Nature> findAllNatures();
}
