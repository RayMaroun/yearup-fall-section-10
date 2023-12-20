package com.pluralsight.NorthwindTradersSpringBoot4.services;


import com.pluralsight.NorthwindTradersSpringBoot4.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersSpringBoot4.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ProductService {
    private final IProductDao productDao;

    @Autowired
    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        productDao.add(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public void deleteProduct(Product product) {
        productDao.delete(product);
    }
}
