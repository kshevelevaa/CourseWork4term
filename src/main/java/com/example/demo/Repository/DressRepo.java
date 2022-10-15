package com.example.demo.Repository;

import com.example.demo.Entity.Dress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface DressRepo extends JpaRepository<Dress, Integer> {
    List<Dress> findAll();
}
