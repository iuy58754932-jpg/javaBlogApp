package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //一覧取得 : GET /articles
    @GetMapping
    public List<Article> getArticles() {
        return articleService.findAll();
    }

    //登録 : POST /articles
    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.create(article);
    }
}
