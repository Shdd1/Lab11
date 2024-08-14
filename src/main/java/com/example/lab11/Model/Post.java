package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = " category_id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer  categoryId;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "title can not be empty")
    private String title;
    @Column(columnDefinition = "varchar(280) not null")
    @Size(max =280,message = "maximum length of content 280 character")
    @NotNull(message = "content can not be null")
    private String content;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "userId can not be null")
    private Integer userId;
    @Column(columnDefinition = "Datetime")
    private LocalDate publishDate;
}
