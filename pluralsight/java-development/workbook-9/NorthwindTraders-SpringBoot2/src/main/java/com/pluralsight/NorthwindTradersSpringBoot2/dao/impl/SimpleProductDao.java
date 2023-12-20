package com.pluralsight.NorthwindTradersSpringBoot2.dao.impl;


import com.pluralsight.NorthwindTradersSpringBoot2.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersSpringBoot2.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements IProductDao {
    private List<Product> products;

    public SimpleProductDao() {
        this.products = new ArrayList<>();
        // Add some initial products
        products.add(new Product(1, "Smartphone", "Electronics", 499.99));
        products.add(new Product(2, "Laptop", "Computers", 899.99));
        products.add(new Product(3, "Headphones", "Audio", 99.99));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        int index = getProductIndex(product.getProductId());
        if (index != -1) {
            products.set(index, product);
        }
    }

    @Override
    public void delete(Product product) {
        int index = getProductIndex(product.getProductId());
        if (index != -1) {
            products.remove(index);
        }
    }

    private int getProductIndex(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }
}
