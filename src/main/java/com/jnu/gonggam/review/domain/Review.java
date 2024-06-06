package com.jnu.gonggam.review.domain;

import com.jnu.gonggam.product.domain.Product;
import com.jnu.gonggam.purchase.domain.Purchase;
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
@Table(name = "review_tb")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_pk")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "purchase_pk")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_pk")
    private Product product;

    @NotNull
    private Integer starAverage;

    @NotNull
    @Column(length = 600)
    private String content;

    @Column(length = 200)
    private String reviewImagePath;

    @NotNull
    @CreatedDate
    private LocalDateTime createAt;

    @NotNull
    @LastModifiedDate
    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    @Builder
    public Review(Long id, Purchase purchase, Product product,
                  Integer starAverage, String content, String reviewImagePath) {
        this.id = id;
        this.purchase = purchase;
        this.product = product;
        this.starAverage = starAverage;
        this.content = content;
        this.reviewImagePath = reviewImagePath;
    }
}
