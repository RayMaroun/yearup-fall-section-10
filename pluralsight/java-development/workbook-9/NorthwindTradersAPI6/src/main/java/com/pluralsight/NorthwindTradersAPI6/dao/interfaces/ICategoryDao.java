package com.pluralsight.NorthwindTradersAPI6.dao.interfaces;


import com.pluralsight.NorthwindTradersAPI6.models.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll();
    Category getById(int id);
    Category insert(Category category);
    void update(int id, Category category);
    void delete(int id);
}
