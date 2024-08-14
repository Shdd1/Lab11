package com.example.lab11.Service;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.Users;
import com.example.lab11.Repository.CategoryRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> getPost() {
        return postRepository.findAll();
    }
    public void addPost(Post post) {
        Users u = userRepository.findUsersById(post.getUserId());
        Category c = categoryRepository.findCategoriesById(post.getCategoryId());
        if (u == null || c==null){
            throw new ApiExeption("category or user not found");
    }
        post.setPublishDate(LocalDate.now());
       postRepository.save(post);
    }
    public void updatePost(Integer id,Post post){
        Post p=postRepository.findPostById(id);
        if(p==null){
            throw new ApiExeption("user not found");
        }
        p.setTitle(post.getTitle());
        p.setPublishDate(post.getPublishDate());
        p.setContent(post.getContent());
        postRepository.save(p);

    }

    public void deletePost(Integer id){
        Post p=postRepository.findPostById(id);
        if(p==null){
            throw new ApiExeption("user not found");
        }
        postRepository.delete(p);
    }
    //************** get all post by user_id **************************
    public List<Post> allPostByUserId(Integer userId){
            List<Post> p=postRepository.findPostByUserId(userId);
        if(p==null){
            throw new ApiExeption("not found");
        }
        return p;

    }

    //***************** get post by title *****************************
    public List<Post> postByTitle(String title){
        List<Post> p=postRepository.findPostByTitle(title);
        if(p==null){
            throw new ApiExeption("not found");
        }
        return p;
    }
    //**************get all post before date by date***************
    public List<Post> postBeforeDate(LocalDate date){
        List<Post> p=postRepository.getAllPostBeforeDate(date);
        if(p==null){
            throw new ApiExeption("not found");
        }
        return p;
    }
    //7.************* get post by category and between two date*****************
    public List<Post>getpostByCategoryAndBetweenTwoDate(Integer categoryId,LocalDate date1,LocalDate date2){
        List<Post> p=postRepository.getPostByCategoryIdAndAndPublishDate(categoryId,date1,date2);
        if(p==null){
            throw new ApiExeption("not found");
        }
        return p;
    }

}
