package com.example.wh_backend.repository;

import com.example.wh_backend.domain.FitnessTrainerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FitnessTrainerProfileRepository extends JpaRepository<FitnessTrainerProfile, UUID> {
}
