package com.jnu.gonggam.user.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender {
    GENDER_MALE("MALE"),
    GENDER_FEMALE("FEMALE");

    private final String gender;
}
