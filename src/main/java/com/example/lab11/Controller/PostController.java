package com.example.lab11.Controller;

import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import com.example.lab11.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getPost() {
        return ResponseEntity.status(200).body(postService.getPost());
    }

    @PostMapping("/add")
    private ResponseEntity addPost(@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body("is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body("is Updated");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(200).body("is deleted");
    }
    //.************** get all post by user_id **************************
    @GetMapping("/getall/{id}")
    public ResponseEntity getAllPostByUserId(@PathVariable Integer id){
        return ResponseEntity.status(200).body(postService.allPostByUserId(id));

    }
    //***************** get post by title *****************************
    @GetMapping("/gett/{title}")
    public ResponseEntity getAllPostByUserId(@PathVariable String title){
        return ResponseEntity.status(200).body(postService.postByTitle(title));
    }
    //**************get all post before date by date***************
    @GetMapping("/getdate/{date}")
    public ResponseEntity getAllPostByUserId(@PathVariable LocalDate date){
        return ResponseEntity.status(200).body(postService.postBeforeDate(date));
    }
    //7.************* get post by category and between two date*****************
    @GetMapping("/getbycat/{id}/{date1}/{date2}")
    public ResponseEntity getAllPostByUserId(@PathVariable  Integer id,@PathVariable  LocalDate date1,@PathVariable LocalDate date2){
        return ResponseEntity.status(200).body(postService.getpostByCategoryAndBetweenTwoDate(id,date1,date2));
    }

}