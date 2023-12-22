package com.pluralsight.NorthwindTradersAPI6.controllers;


import com.pluralsight.NorthwindTradersAPI6.dao.interfaces.ICategoryDao;
import com.pluralsight.NorthwindTradersAPI6.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {
    private final ICategoryDao categoryDao;

    @Autowired
    public CategoriesController(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        List<Category> categories = categoryDao.getAll();
        return categories;
    }


    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryDao.getById(categoryId);
    }

    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.PUT)
    public void updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
        categoryDao.update(categoryId, category);
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int categoryId) {
        categoryDao.delete(categoryId);
    }
}
