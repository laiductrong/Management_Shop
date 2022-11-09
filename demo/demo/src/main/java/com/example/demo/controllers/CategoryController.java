package com.example.demo.controllers;

import com.example.demo.models.CategoryEntity;
import com.example.demo.repository.CategoryRepos;
import com.example.demo.repository.ReposiveObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Category")
public class CategoryController {
    @Autowired
    private CategoryRepos categoryRepos;

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<CategoryEntity> getAllCategories() {
        return categoryRepos.findAll();
    }

    @GetMapping("/getByIDCategory/{idCategory}")
    public @ResponseBody
    ReposiveObject getCategoryByID(@PathVariable String idCategory) {
        Optional<CategoryEntity> foundCategory = categoryRepos.findById(idCategory);
        return foundCategory.isPresent() ? new ReposiveObject("oke", "success", foundCategory) : new ReposiveObject("fail", "fail find category", "");
    }

    @PostMapping("/insertCategory")
    public @ResponseBody
    ReposiveObject insertCategory(@RequestBody CategoryEntity category) {
        return new ReposiveObject("oke", "insert success", categoryRepos.save(category));
    }
}
