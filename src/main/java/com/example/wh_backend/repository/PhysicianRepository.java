package com.example.wh_backend.repository;

import com.example.wh_backend.domain.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends JpaRepository<Psychologist,String> {
}
