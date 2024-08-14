package com.example.lab11.Repository;

import com.example.lab11.Model.Post;
import com.example.lab11.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findPostById(Integer id);

    List<Post> findPostByUserId(Integer userId);

    List<Post> findPostByTitle(String title);

    @Query("select d from Post d where d.publishDate<?1")
    List<Post> getAllPostBeforeDate(LocalDate date);

    @Query("select p from Post p where p.categoryId=?1 and p.publishDate>=?2 and p.publishDate<=?2 ")
    List<Post>getPostByCategoryIdAndAndPublishDate(Integer id,LocalDate date1,LocalDate date2);
}
