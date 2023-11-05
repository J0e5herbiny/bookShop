package com.joe.project.security.jwtFilters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UsernamePasswordAuthRequest {

    private String username;
    private String password;

}
