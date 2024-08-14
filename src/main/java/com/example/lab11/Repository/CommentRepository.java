package com.example.lab11.Repository;

import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findCommentById(Integer id);

    @Query("select p from Comment p where p.postId=?1")
    List<Comment> getAllCommentByPostId(Integer postId);

    @Query("select t from Comment t where t.commentDate>?1 and t.commentDate<?2")
    List<Comment> getALLCommentBetweenTowDate(LocalDate date1, LocalDate date2);

}
