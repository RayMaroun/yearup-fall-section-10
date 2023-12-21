package com.pluralsight.NorthwindTradersAPI3.dao.interfaces;


import com.pluralsight.NorthwindTradersAPI3.models.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getAll();

    Product getById(int id);
}
