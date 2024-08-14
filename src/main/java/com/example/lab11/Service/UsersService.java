package com.example.lab11.Service;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Model.Users;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
     private final UserRepository userRepository;
    public List<Users> getUser() {
        return userRepository.findAll();
    }
    public void addUser(Users users){
       users.setRegistrationDate(LocalDate.now());
        userRepository.save(users);
    }
    public void updateUser(Integer id,Users users){
        Users u=userRepository.findUsersById(id);
        if(u==null){
            throw new ApiExeption("user not found");
        }
        u.setUsername(users.getUsername());
        u.setPassword(users.getPassword());
        u.setEmail(users.getEmail());
        u.setRegistrationDate(users.getRegistrationDate());
        userRepository.save(u);
    }

    public void deleteUser(Integer id){
        Users u=userRepository.findUsersById(id);
        if(u==null){
            throw new ApiExeption("user not found");
        }
        userRepository.delete(u);
    }
    //6.************get Users By Registration Date****************
    public List<Users> getUserByRegistrationDate(LocalDate date){
       List<Users>  u=userRepository.getUserByRegistrationDate(date);
        if(u==null){
            throw new ApiExeption("user not found");
        }
     return u;
    }

    //8.************** Get user by email ******************
    public Users GetUserByEmail(String email){
        Users u=userRepository.findUsersByEmail(email);
        if(u==null){
            throw new ApiExeption("email not found");
        }
        return u;
    }
}
