package com.example.demo.service;

import com.example.demo.model.ArticleConfig;
import com.example.demo.model.ArticleSimple;
import com.example.demo.repository.ArticleConfigRepository;
import com.example.demo.repository.ArticleSimpleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.fixture.ArticleConfigFixture.createArticleConfig;
import static com.example.demo.fixture.ArticleConfigFixture.createSimples;
import static java.util.UUID.randomUUID;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ArticleConfigService {

    private final ArticleConfigRepository articleConfigRepository;
    private final ArticleSimpleRepository articleSimpleRepository;

    @Transactional
    public void createArticles() {

        List<ArticleConfig> newConfigs = new ArrayList<>();
        List<ArticleSimple> newSimples = new ArrayList<>();

        List<Integer> configIDsForUpdate = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String configSKU = randomUUID().toString();
            ArticleConfig config = createArticleConfig(configSKU);
            newConfigs.add(config);
            List<ArticleSimple> simples = createSimples(config);
            newSimples.addAll(simples);
        }
        long startTime = System.currentTimeMillis();
        articleConfigRepository.saveAll(newConfigs);
        articleConfigRepository.flush();
        articleSimpleRepository.saveAll(newSimples);
        articleSimpleRepository.flush();
        long endTime = System.currentTimeMillis();

        ArticleSimple simple = articleSimpleRepository.findById(1l).get();

        System.out.println("Config SKU of First Simple: " + simple.getArticleConfig().getConfigSKU());
        System.out.println("total time in milli secs -> " + (endTime - startTime));

        System.out.println("total configs in the table-->");
        List<ArticleConfig> allConfigs = articleConfigRepository.findAll();
        System.out.println(allConfigs.size());
        System.out.println("total simples in the table-->");
        System.out.println(articleSimpleRepository.findAll().size());

        /**
         * Updating
         */
        List<ArticleConfig> configsForUpdates = allConfigs.subList(0, 10);
        configsForUpdates.get(0).setBrandCode("Updated Brand Code");
        configsForUpdates.get(4).setBrandCode("Updated Brand Code");
        configsForUpdates.get(5).setBrandCode("Updated Brand Code");

        List<ArticleSimple> simplesForUpdate = articleSimpleRepository.findByArticleConfigIdIn(
                List.of(configsForUpdates.get(0).getId(), configsForUpdates.get(3).getId(), configsForUpdates.get(5).getId())
        );

        for (int i = 0; i < 12; i++) {
            simplesForUpdate.get(i).setEan("Updated EAN");
        }
    }
}
