package com.example.demo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //全件取得
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    //1件登録
    public Article create(Article article) {
        return articleRepository.save(article);
    }
}
