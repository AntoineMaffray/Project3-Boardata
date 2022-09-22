package com.eql.project3.boardata.repository;

import com.eql.project3.boardata.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName (String name);
}
