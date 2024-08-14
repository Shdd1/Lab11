package com.example.lab11.Controller;

import com.example.lab11.Model.Users;
import com.example.lab11.Service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(usersService.getUser());
    }
    @PostMapping("/add")
    private ResponseEntity addUser(@Valid @RequestBody Users users, Errors errors){
        if(errors.hasErrors()){
            String massege=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        usersService.addUser(users);
        return ResponseEntity.status(200).body("is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody Users users,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        usersService.updateUser(id,users);
        return ResponseEntity.status(200).body("user Updated");
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteUser(@PathVariable Integer id){
        usersService.deleteUser(id);
        return ResponseEntity.status(200).body("user is deleted");
    }
    //6.************get Users By Registration Date****************
    @GetMapping("/getdate/{date}")
    public ResponseEntity getAllPostByUserId(@PathVariable LocalDate date){
        return ResponseEntity.status(200).body(usersService.getUserByRegistrationDate(date));
    }
   //8.************* get user by email***************************
   @GetMapping("gete/{email}")
   public ResponseEntity getUserByEmail(@PathVariable String email){

       return ResponseEntity.status(200).body(usersService.GetUserByEmail(email));
   }


}
