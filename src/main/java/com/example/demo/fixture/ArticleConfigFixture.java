package com.example.demo.fixture;

import com.example.demo.model.ArticleConfig;
import com.example.demo.model.ArticleSimple;

import java.util.List;

import static java.util.UUID.randomUUID;

public class ArticleConfigFixture {
    public static final String CONFIG_SKU = "configSku";
    public static final String SUBUNIT_CODE = "SUNIT25";
    public static final String ARTICLE_SEASON = "articleSeason";
    public static final String BRAND_NAME = "Adidas";
    public static final String BRAND_CODE = "A11";
    public static final String SUPPLIER_NAME = "white shoe";
    public static final String SUPPLIER_CODE = "XYZ123";

    public static ArticleConfig createArticleConfig() {
        return createArticleConfig(CONFIG_SKU);
    }

    public static ArticleConfig createArticleConfigWithConfigSKU(String configSku) {
        return createArticleConfig(configSku);
    }

    public static List<ArticleSimple> createSimples(ArticleConfig config) {
        return List.of(
                ArticleSimple.builder().simpleSKU(randomUUID().toString()).ean(randomUUID().toString()).size(randomUUID().toString()).articleConfig(config).build(),
                ArticleSimple.builder().simpleSKU(randomUUID().toString()).ean(randomUUID().toString()).size(randomUUID().toString()).articleConfig(config).build(),
                ArticleSimple.builder().simpleSKU(randomUUID().toString()).ean(randomUUID().toString()).size(randomUUID().toString()).articleConfig(config).build(),
                ArticleSimple.builder().simpleSKU(randomUUID().toString()).ean(randomUUID().toString()).size(randomUUID().toString()).articleConfig(config).build(),
                ArticleSimple.builder().simpleSKU(randomUUID().toString()).ean(randomUUID().toString()).size(randomUUID().toString()).articleConfig(config).build(),
                ArticleSimple.builder().simpleSKU(randomUUID().toString()).ean(randomUUID().toString()).size(randomUUID().toString()).articleConfig(config).build()
        );
    }

    public static ArticleConfig createArticleConfig(String configSku) {
        return ArticleConfig.builder()
                .configSKU(configSku)
                .supplierName(SUPPLIER_NAME)
                .supplierCode(SUPPLIER_CODE)
                .brandName(BRAND_NAME)
                .brandCode(BRAND_CODE)
                .build();
    }

    public static ArticleConfig createUpdatedArticleConfig(String configSku) {
        return ArticleConfig.builder()
                .configSKU(configSku)
                .supplierName(SUPPLIER_NAME + "updated")
                .supplierCode(SUPPLIER_CODE + "updated")
                .brandName(BRAND_NAME + "updated")
                .brandCode(BRAND_CODE + "updated")
                .build();
    }
}
