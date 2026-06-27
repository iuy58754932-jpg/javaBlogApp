package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    //1件取得
    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.findById(id);
    }

    //更新
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return articleService.update(id, article);
    }

    //削除
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
    }
}
