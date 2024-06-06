package com.jnu.gonggam.user.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ROLE_BUYER("BUYER"),
    ROLE_SELLER("SELLER");

    private final String role;
}
