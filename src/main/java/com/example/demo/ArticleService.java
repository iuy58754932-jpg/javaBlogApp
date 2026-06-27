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

    //1件取得
    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("記事が見つかりません: id =" + id));
    }

    //更新
    public Article update(Long id, Article article) {
        Article existing = findById(id);
        existing.setTitle(article.getTitle());
        existing.setContent(article.getContent());
        return articleRepository.save(existing);
    }

    //削除
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
