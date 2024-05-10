package com.shubz.conduit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shubz.conduit.models.Article;

@Service
public class ArticleService {
    
    private final List<Article> articles = new ArrayList<>();

    public List<Article> findAll() {
        return articles;
    }

    public List<Article> findArticlesByAuthor(String author) {

        List<Article> articles_by_author = new ArrayList<>();

        for (Article article: articles){
            if (article.getAuthor() == null ? author == null : article.getAuthor().equals(author)){
                articles_by_author.add(article);
            }
        }

        return articles_by_author;
    }

    public List<Article> findArticleByTag(String tag){

        List<Article> articles_by_tag = new ArrayList<>();

        for (Article article: articles){
            List<String> tagList =  article.getTags();

            for (String articletag: tagList){
                if (articletag == null ? tag == null : articletag.equals(tag)){
                    articles_by_tag.add(article);
                    break;
                }
            }

        }

        return articles_by_tag;
    }


    public void createArticle(Article article){
        this.articles.add(article);
    }

}
