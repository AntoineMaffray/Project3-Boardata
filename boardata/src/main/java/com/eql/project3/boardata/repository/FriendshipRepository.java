package com.eql.project3.boardata.repository;

import com.eql.project3.boardata.models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipRepository extends JpaRepository <Friendship, Long> {

}
