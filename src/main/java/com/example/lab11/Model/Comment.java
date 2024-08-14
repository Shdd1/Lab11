package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "user can not be null")
    private Integer userId;
    @Column(columnDefinition = "int not null")
    @NotNull(message = " post can not be null")
    private Integer postId;
    @Column(columnDefinition = "varchar(50) not null")
    @Size(max =50,message = "maximum length of content 50 character")
    @NotNull(message = "content can not be null")
    private String content;
    @Column(columnDefinition = "Datetime")
    private LocalDate commentDate;

}
