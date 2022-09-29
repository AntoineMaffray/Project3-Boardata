package com.eql.project3.boardata.repository;

import com.eql.project3.boardata.models.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

}
