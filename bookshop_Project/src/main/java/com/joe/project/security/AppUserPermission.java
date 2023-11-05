package com.joe.project.security;

public enum AppUserPermission {

    BOOK_WRITE("book:write"),
    BOOK_READ("book:read"),
    CATEGORY_WRITE("category:write"),
    CATEGORY_READ("category:read");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
