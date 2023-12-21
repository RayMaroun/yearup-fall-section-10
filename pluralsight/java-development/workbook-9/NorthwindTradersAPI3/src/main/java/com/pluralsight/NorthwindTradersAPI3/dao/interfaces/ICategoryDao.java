package com.pluralsight.NorthwindTradersAPI3.dao.interfaces;


import com.pluralsight.NorthwindTradersAPI3.models.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll();

    Category getById(int id);
}
