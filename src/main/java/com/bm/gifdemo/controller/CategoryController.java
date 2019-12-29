package com.bm.gifdemo.controller;

import com.bm.gifdemo.model.Category;
import com.bm.gifdemo.model.Gif;
import com.bm.gifdemo.repository.CategoryRepository;
import com.bm.gifdemo.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {

        List<Category> categories = categoryRepository.getAllCategories();

        modelMap.put("categories", categories);

        return "categories";

    }

    @GetMapping("/category/{id}")
    public String getGifsByCategory(@PathVariable int id, ModelMap modelMap) {

        List<Gif> gifList = gifRepository.getGifsByCategoryId(id);
        Category category = categoryRepository.getCategoryById(id);

        modelMap.put("gifs", gifList);
        modelMap.put("category", category);

        return "category";


    }

}
