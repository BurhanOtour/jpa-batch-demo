package com.example.demo.repository;

import com.example.demo.model.ArticleSimple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ArticleSimpleRepository extends JpaRepository<ArticleSimple, Long> {
    List<ArticleSimple> findByArticleConfigIdIn(List<Long> articleConfigIDs);
}