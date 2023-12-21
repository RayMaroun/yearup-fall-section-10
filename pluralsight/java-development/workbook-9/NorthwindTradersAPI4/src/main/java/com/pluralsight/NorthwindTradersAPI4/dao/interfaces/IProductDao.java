package com.pluralsight.NorthwindTradersAPI4.dao.interfaces;



import com.pluralsight.NorthwindTradersAPI4.models.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getAll();
    Product getById(int id);

    Product insert(Product product);
}
