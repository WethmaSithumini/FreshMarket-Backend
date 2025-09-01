package com.agriMarket.backend.repository;

import com.agriMarket.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
    User findByUsername(String username);


}