package com.pluralsight.NorthwindTradersAPI4.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI4.models.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll();
    Category getById(int id);

    Category insert(Category category);
}
