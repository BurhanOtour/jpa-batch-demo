package com.example.demo;

import com.example.demo.service.ArticleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    ArticleConfigService articleConfigService;


    @GetMapping("/create-articles")
    public String greeting() {
        articleConfigService.createArticles();
        return "Created!";
    }
}
