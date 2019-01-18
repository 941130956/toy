package com.cpc.elastisearch.util;

import java.awt.AWTException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.cpc.elastisearch.dao.es.pojo.Product;
import org.springframework.core.io.UrlResource;


public class ProductUtil {

    public  List<Product> file2list(String fileName) throws IOException {

        File f = new File(ClassLoader.getSystemResource("140k_products.txt").getFile());
//        URL url= this.getClass().getClassLoader().getResource(fileName);
//        UrlResource resource = new UrlResource(url);
//        InputStream inputStream= resource.getInputStream();
        List<String> lines = FileUtils.readLines(f, "UTF-8");
        List<Product> products = new ArrayList<>();
        for (String line : lines) {
            Product p = line2product(line);
            products.add(p);
        }
        return products;
    }

    private  Product line2product(String line) {
        Product p = new Product();
        String[] fields = line.split(",");
        p.setId(Integer.parseInt(fields[0]));
        p.setName(fields[1]);
        p.setCategory(fields[2]);
        p.setPrice(Float.parseFloat(fields[3]));
        p.setPlace(fields[4]);
        p.setCode(fields[5]);
        p.setKeyWord(p.getName()+p.getCategory()+p.getPlace());
        return p;
    }

}
