package com.bm.gifdemo.repository;

import com.bm.gifdemo.model.Category;
import com.bm.gifdemo.model.Gif;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;


@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(0,"funny"),
            new Category(1,"sport"),
            new Category(2,"it")


    );

    public static List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }


    public Category getCategoryById(int id){
        for (Category g : getAllCategories()) {
            if (g.getId() == id) {
                return g;


            }
        }
        return null;
    }




}
