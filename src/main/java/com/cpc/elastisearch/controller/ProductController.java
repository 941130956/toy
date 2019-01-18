package com.cpc.elastisearch.controller;


import com.cpc.elastisearch.dao.es.pojo.Product;
import com.cpc.elastisearch.dao.es.repository.ProductRepository;
import org.elasticsearch.common.lucene.search.function.FiltersFunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/queryproduct")
    public String listCategory(Model m,@RequestParam(value = "keyword", defaultValue = "随便") String keyword, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        //查询条件，但是并未使用，放在这里，为的是将来使用，方便参考，知道如何用
        //   String query = "第一次";
        SearchQuery searchQuery = getEntitySearchQuery(start, size, keyword);
        Page<Product> page = productRepository.search(searchQuery);
        m.addAttribute("page", page);
        return "listProduct";
    }


    /**
     * spring data es 封装 方式
     *
     * @param start
     * @param size
     * @param searchContent
     * @return
     */
    private SearchQuery getEntitySearchQuery(int start, int size, String searchContent) {
//        QueryBuilders.matchAllQuery()   查询所有
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(QueryBuilders.matchPhraseQuery("keyWord", searchContent),
                ScoreFunctionBuilders.weightFactorFunction(100));
//                查询条件，但是并未使用，放在这里，为的是将来使用，方便参考，知道如何用
//                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
//                      ScoreFunctionBuilders.weightFactorFunction(100))
        //设置权重分 求和模式
        functionScoreQueryBuilder.scoreMode(FiltersFunctionScoreQuery.ScoreMode.SUM);
        //设置权重分最低分
        functionScoreQueryBuilder.setMinScore(1);
        // 设置分页
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }
}
