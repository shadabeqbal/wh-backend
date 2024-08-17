package com.example.wh_backend.repository;

import com.example.wh_backend.domain.AllUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AllUserRepository extends JpaRepository<AllUsers,String> {

    @Query("from AllUsers c where c.email = :email")
    AllUsers userEmailExists(String email);

}
