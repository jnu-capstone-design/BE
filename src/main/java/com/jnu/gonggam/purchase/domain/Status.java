package com.jnu.gonggam.purchase.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Status {
    STATUS_UNCOMPLETED("UNCOMPLETED"),
    STATUS_COMPLETED("COMPLETED"),
    STATUS_CANCELED("CANCELED");

    private final String status;
}
