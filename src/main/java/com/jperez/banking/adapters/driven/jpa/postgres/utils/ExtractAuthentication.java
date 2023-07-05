package com.jperez.banking.adapters.driven.jpa.postgres.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class ExtractAuthentication {

    private ExtractAuthentication() {}

    public static String extractEmail() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
