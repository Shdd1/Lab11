package com.example.lab11.Repository;

import com.example.lab11.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findUsersById(Integer id);
    @Query("select d from Users d where d.registrationDate=?1")
    List<Users> getUserByRegistrationDate(LocalDate date);
    Users findUsersByEmail(String email);
}
