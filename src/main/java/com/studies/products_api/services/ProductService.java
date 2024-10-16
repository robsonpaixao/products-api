package com.studies.products_api.services;

import com.studies.products_api.models.Product;
import com.studies.products_api.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private static final String REDIS_KEY = "products";

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RedisService redisService;

    public List<Product> findAllProducts() {
        List<Product> products = (List<Product>) redisService.getData(REDIS_KEY);
        if(products != null) log.info("[ ProductService.findAllProducts ] [ Retrieve data from Redis ]");

        if(products == null) {
            products = productRepository.findAll();
            redisService.saveData(REDIS_KEY, products);
        }

        return products;
    }
}
