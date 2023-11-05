package com.joe.project.security.jwtFilters;

import com.google.common.net.HttpHeaders;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Configuration
@Component  // This or @Configuration can be used
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {

    private String secretKey;
    private String prefixToken;
    private Integer expDate;

    public JwtConfig() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPrefixToken() {
        return prefixToken;
    }

    public void setPrefixToken(String prefixToken) {
        this.prefixToken = prefixToken;
    }

    public Integer getExpDate() {
        return expDate;
    }

    public void setExpDate(Integer expDate) {
        this.expDate = expDate;
    }

    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }

}
