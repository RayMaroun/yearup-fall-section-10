package com.pluralsight.NorthwindTradersAPI5.dao.interfaces;


import com.pluralsight.NorthwindTradersAPI5.models.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll();
    Category getById(int id);
    Category insert(Category category);
    void update(int id, Category category);
}
