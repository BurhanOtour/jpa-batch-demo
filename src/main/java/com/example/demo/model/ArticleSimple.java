package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "ArticleSimple")
@Table(name = "article_simples")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSimple {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "article_simple_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_config_id", referencedColumnName = "id", nullable = false)
    private ArticleConfig articleConfig;

    @Column(name = "simple_sku", nullable = false, updatable = false)
    private String simpleSKU;

    @Column(name = "ean")
    private String ean;

    @Column(name = "size")
    private String size;
}