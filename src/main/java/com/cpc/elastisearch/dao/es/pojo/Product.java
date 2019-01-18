package com.cpc.elastisearch.dao.es.pojo;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;



@Document(indexName = "toy", type = "product", refreshInterval = "20s", replicas = 2)
public class Product {
    /**
     * id
     */
    @Id
    @Field(type = FieldType.Integer)
    private Integer id;

    /**
     * 名称
     */
    @Field(type = FieldType.Text)
    private String name;

    /**
     * 分类
     */
    @Field(type = FieldType.Text)
    private String category;

    /**
     * 价格
     */
    @Field(type = FieldType.Keyword)
    private Float price;

    /**
     * 生产地
     */
    @Field(type = FieldType.Text)
    private String place;

    /**
     * 编码
     */
    @Field(type = FieldType.Keyword)
    private String code;
    /**
     * 搜索 关键字  名称_分类名_产地
     */
    @Field(type = FieldType.Text)
    private String keyWord;


    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
