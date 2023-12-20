package com.pluralsight.NorthwindTradersSpringBoot4.dao.interfaces;



import com.pluralsight.NorthwindTradersSpringBoot4.models.Product;

import java.util.List;

public interface IProductDao {
    void add(Product product);

    List<Product> getAll();

    Product getProductById(int productId);

    void update(Product product);

    void delete(Product product);
}
