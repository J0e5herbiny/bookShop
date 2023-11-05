package com.joe.project.security;

import com.joe.project.security.jwtFilters.JwtConfig;
import com.joe.project.security.jwtFilters.JwtTokenVerifierFilter;
import com.joe.project.security.jwtFilters.JwtUsernamePasswordAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

//@Configuration
//@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;
    private JwtConfig jwtConfig;
    private SecretKey secretKey;

    @Autowired
    public AppSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtConfig jwtConfig, SecretKey secretKey) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()

                .addFilter(new JwtUsernamePasswordAuthFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifierFilter(jwtConfig, secretKey), JwtUsernamePasswordAuthFilter.class)
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

}
