package com.shubz.conduit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubz.conduit.dto.ArticlePostDTO;
import com.shubz.conduit.models.Article;
import com.shubz.conduit.services.ArticleService;



@RestController
@RequestMapping("/articles")
public class ArticleController {


    @Autowired
    private ArticleService articleService;


    @PostMapping(value="")
    public String postArticle(@RequestBody ArticlePostDTO request) {
        

        System.out.println("In post method");
        System.out.println("request: " + request);
        Article article = new Article();

        int id = (int) (Math.random() * 100);

        article.setId(id);
        article.setAuthor("shubz");
        article.setContent(request.getBody());
        article.setTitle(request.getTitle());
        article.setTags(request.getTagList());
        article.setDescription(request.getDescription());

        articleService.createArticle(article);
       
        return "Successfully created an article!";
    }
    

    @GetMapping(value="/")
    @ResponseBody
    public List<Article> getAllArticles(){
        System.out.println("in articles");
        // implement the service for this
        return articleService.findAll();
    }

    

    @GetMapping(value="/", params={"author"})
    @ResponseBody
    public List<Article> getArticlesByAuthor(@RequestParam String author) {

        //return new String();
        return articleService.findArticlesByAuthor(author);
    }



    @GetMapping(value="/", params={"tag"})
    @ResponseBody
    public List<Article> getArticlesByTags(@RequestParam String tag) {

        //return new String();
        return articleService.findArticleByTag(tag);
    }

    
    /* 
    @GetMapping("/")
    @ResponseBody
    public List<String> getArticlesByFavourites(@RequestParam String favorited) {

        //return new String();
        return Nullable;
    }
    */

    
   
}
