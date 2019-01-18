package com.cpc.elastisearch.dao.es.repository;


import com.cpc.elastisearch.dao.es.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,Integer> {


}
