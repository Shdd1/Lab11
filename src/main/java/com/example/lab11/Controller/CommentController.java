package com.example.lab11.Controller;

import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Users;
import com.example.lab11.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/get")
    public ResponseEntity getComment(){
        return ResponseEntity.status(200).body(commentService.getComment());
    }
    @PostMapping("/add")
    private ResponseEntity addComment(@Valid @RequestBody Comment comment, Errors errors){
        if(errors.hasErrors()){
            String massege=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body("is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@Valid@RequestBody Comment comment,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.updateComment(id,comment);
        return ResponseEntity.status(200).body("user Updated");
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body("user is deleted");
    }
    //get post by title, get all comment for one post by post_id
    @GetMapping("/getc/{postId}")
    public ResponseEntity getAllCommentByPostId(@PathVariable Integer postId){
        return ResponseEntity.status(200).body(commentService.getCommentByPostId(postId));
    }
    //5.*************** get Comment between two date**************
    @GetMapping("/getdate/{date1}/{date2}")
    public ResponseEntity getAllCommentBetweenTwoDate(@PathVariable LocalDate date1, @PathVariable LocalDate date2){
        return ResponseEntity.status(200).body(commentService.getCommentBetweenTwoDate(date1,date2));
    }


}
