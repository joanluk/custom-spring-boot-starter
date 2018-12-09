package org.emaginalabs.security.jwt.repository.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenState {
    private String accessToken;
    private Integer expiresIn;


}