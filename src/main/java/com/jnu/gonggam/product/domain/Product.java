package com.jnu.gonggam.product.domain;

import com.jnu.gonggam.category.domain.Category;
import com.jnu.gonggam.company.domain.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "product_tb")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_pk")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_pk")
    private Category category;

    @NotNull
    @Column(length = 45)
    private String name;

    @NotNull
    private Integer stock;

    @NotNull
    private Integer purchasePrice;

    @NotNull
    private Integer regularPrice;

    @NotNull
    private Integer discountRate;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime expireAt;

    @NotNull
    @CreatedDate
    private LocalDateTime createAt;

    @NotNull
    @LastModifiedDate
    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    @Builder
    public Product(Long id, Company company, Category category, String name, Integer stock,
                   Integer purchasePrice, Integer regularPrice, String content, LocalDateTime expireAt) {
        this.id = id;
        this.company = company;
        this.category = category;
        this.name = name;
        this.stock = stock;
        this.purchasePrice = purchasePrice;
        this.regularPrice = regularPrice;
        this.discountRate = (purchasePrice * 100) / regularPrice;
        this.content = content;
        this.expireAt = expireAt;
    }
}
