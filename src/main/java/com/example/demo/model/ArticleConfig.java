package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "ArticleConfig")
@Table(
        name = "article_configs"
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleConfig {
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "article_config_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "config_sku", nullable = false, updatable = false)
    private String configSKU;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "brand_code")
    private String brandCode;

    @Column(name = "brand_name")
    private String brandName;
}
