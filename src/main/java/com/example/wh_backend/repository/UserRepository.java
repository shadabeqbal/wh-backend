package com.example.wh_backend.repository;

import com.example.wh_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("from User c where c.email = :email")
    User userEmailExists(String email);

    @Query("from User c where c.mobile = :mobile")
    User userMobileExists(String mobile);

    @Query("from User c where c.email = :email")
    User getUserByEmail(String email);
}
