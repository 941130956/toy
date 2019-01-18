package com.cpc.elastisearch.dao.es.repository;

import com.cpc.elastisearch.dao.es.pojo.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category,Integer> {

}
