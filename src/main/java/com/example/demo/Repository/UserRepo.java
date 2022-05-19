package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
