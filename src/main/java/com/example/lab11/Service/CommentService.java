package com.example.lab11.Service;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.Users;
import com.example.lab11.Repository.CommentRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }
    public void addComment(Comment comment){
        Users u=userRepository.findUsersById(comment.getUserId());
        Post p=postRepository.findPostById(comment.getPostId());
        if(u==null||p==null){
            throw new ApiExeption("user or post not found");
        }
        comment.setCommentDate(LocalDate.now());
        commentRepository.save(comment);
    }
    public void updateComment(Integer id,Comment comment){
        Comment c=commentRepository.findCommentById(id);
        if(c==null){
            throw new ApiExeption("user not found");
        }
       c.setCommentDate(comment.getCommentDate());
        commentRepository.save(c);
    }

    public void deleteComment(Integer id){
        Comment c=commentRepository.findCommentById(id);
        if(c==null){
            throw new ApiExeption("user not found");
        }
        commentRepository.delete(c);
    }
   //**************** get all comment for one post by post_id*******************
    public List<Comment> getCommentByPostId(Integer postId){
        List<Comment> c=commentRepository.getAllCommentByPostId(postId);
        if(c.isEmpty()){
            throw new ApiExeption("post not found");
        }
        return c;
    }
    //5.*************** get Comment between two date**************
    public List<Comment> getCommentBetweenTwoDate(LocalDate date1, LocalDate date2){
        List<Comment> c=commentRepository.getALLCommentBetweenTowDate(date1,date2);
        if(c.isEmpty()){
            throw new ApiExeption("not found");
        }
        return c;

    }

}
