package com.example.demo.service;

import com.example.demo.model.ArticleConfig;
import com.example.demo.repository.ArticleConfigRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;
import static com.example.demo.fixture.ArticleConfigFixture.*;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ArticleConfigService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ArticleConfigRepository articleConfigRepository;

    @Transactional
    public void createArticles() {
       // List<String> listOFConfigForUpdating = new ArrayList<>();
        List<ArticleConfig> newConfigs = new ArrayList<>();

        for (int i =0; i < 200; i++) {
            String configSKU = randomUUID().toString();
            ArticleConfig config = createArticleConfigWithConfigSKU(configSKU);
            newConfigs.add(config);
        }
        articleConfigRepository.saveAll(newConfigs);

        /*while (index < 10) {
            String configSKU = randomUUID().toString();
            if (index < 2) {
                listOFConfigForUpdating.add(configSKU);
            }
            ArticleConfig config = createArticleConfigWithConfigSKU(configSKU);
            entityManager.persist(config);
            newConfigs.add(config);
            index++;
        }*/

        // List<ArticleConfig> configSKUToUpdate = articleConfigRepository.findByConfigSKUIn(listOFConfigForUpdating);
        // configSKUToUpdate.forEach(e -> e.setBrandCode("UpdatedBrandCode"));
        // articleConfigRepository.saveAll(configSKUToUpdate);
    }
}
