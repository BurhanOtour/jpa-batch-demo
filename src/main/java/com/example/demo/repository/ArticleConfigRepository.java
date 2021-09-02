package com.example.demo.repository;

import com.example.demo.model.ArticleConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ArticleConfigRepository extends JpaRepository<ArticleConfig, Long> {

    List<ArticleConfig> findByConfigSKUIn(Collection<String> configSKUs);
}


