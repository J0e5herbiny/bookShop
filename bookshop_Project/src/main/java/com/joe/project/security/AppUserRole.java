package com.joe.project.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.joe.project.security.AppUserPermission.*;

public enum AppUserRole {

    ADMIN(Sets.newHashSet(BOOK_READ, BOOK_WRITE, CATEGORY_READ, CATEGORY_WRITE)),
    AUTH_USER(Sets.newHashSet(BOOK_READ, CATEGORY_READ));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){

        Set<SimpleGrantedAuthority> prmsn =
                permissions
                        .stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                        .collect(Collectors.toSet());

        prmsn.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return prmsn;

    }

}
