package com.example.classbdemo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classbdemo.enumerations.ERoleName;
import com.example.classbdemo.model.Role;

public interface IRoleRepository  extends JpaRepository<Role, Long>{
    Optional<Role> findByName(ERoleName roleName);
}
