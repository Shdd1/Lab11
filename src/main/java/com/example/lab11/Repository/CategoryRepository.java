package com.example.lab11.Repository;

import com.example.lab11.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findCategoriesById(Integer id);


}
