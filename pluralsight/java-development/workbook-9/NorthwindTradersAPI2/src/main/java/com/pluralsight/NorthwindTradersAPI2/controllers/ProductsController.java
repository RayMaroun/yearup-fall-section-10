package com.pluralsight.NorthwindTradersAPI2.controllers;

import com.pluralsight.NorthwindTradersAPI2.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> products;

    public ProductsController() {
        // Initialize temporary products list
        products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 1, 9.99));
        products.add(new Product(2, "Product 2", 2, 19.99));
        products.add(new Product(3, "Product 3", 1, 9.99));
        // Add more products as needed
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return products;
    }

/*    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Integer categoryId,
                                        @RequestParam(required = false) Double price) {
        List<Product> filteredProducts = products;

        // Filter by name if provided
        if (name != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }

        // Filter by categoryId if provided
        if (categoryId != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(p -> p.getCategoryId() == categoryId)
                    .collect(Collectors.toList());
        }

        // Filter by price if provided
        if (price != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(p -> p.getUnitPrice() == price)
                    .collect(Collectors.toList());
        }

        return filteredProducts;
    }*/

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Return null if product with given ID is not found
    }
}
