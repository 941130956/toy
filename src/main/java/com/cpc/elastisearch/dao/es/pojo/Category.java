package com.cpc.elastisearch.dao.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "elastisearch", type = "category", refreshInterval = "20s", replicas = 2)
public class Category {

    @Id
    @Field(type = FieldType.Integer)
    private Integer id;

    //    @Field(type = FieldType.Keyword ,analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    @Field(type = FieldType.Text)
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
