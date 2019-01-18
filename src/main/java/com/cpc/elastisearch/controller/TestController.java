package com.cpc.elastisearch.controller;


import com.cpc.elastisearch.dao.es.pojo.Product;
import com.cpc.elastisearch.dao.es.repository.ProductRepository;
import com.cpc.elastisearch.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("go")
    public String addAll(){
        String fileName = "140k_products.txt";
        List<Product> products = null;
        try {
            products = new ProductUtil().file2list(fileName);
            productRepository.saveAll(products);
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
