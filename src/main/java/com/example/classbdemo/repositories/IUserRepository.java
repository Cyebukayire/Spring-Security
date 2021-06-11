package com.example.classbdemo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classbdemo.model.User;

import java.util.Optional;

public interface IUserRepository  extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String usernameOrMobileOrEmail);

    Optional<User> findByEmailOrMobileOrUsername(String usernameOrMobileOrEmail, String usernameOrMobileOrEmail2,
                                                 String usernameOrMobileOrEmail3);

    boolean existsByEmail(String email);

    boolean existsByMobile(String mobile);

}
