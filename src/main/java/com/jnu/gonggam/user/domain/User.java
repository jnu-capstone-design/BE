package com.jnu.gonggam.user.domain;

import com.jnu.gonggam.location.domain.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_pk")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_pk")
    private Location location;

    @NotNull
    @Column(length = 20)
    private String identifier;

    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Column(length = 45)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Column(length = 20)
    private String telephone;

    @NotNull
    private LocalDate birth;

    @NotNull
    @CreatedDate
    private LocalDateTime createAt;

    @NotNull
    @LastModifiedDate
    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    @Builder
    public User(Long id, Location location, String identifier, String password,
                Role role, String name, Gender gender, String telephone, LocalDate birth) {
        this.id = id;
        this.location = location;
        this.identifier = identifier;
        this.password = password;
        this.role = role;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.birth = birth;
    }
}
