package org.emaginalabs.security.jwt.repository.model;


import java.sql.Timestamp;

public interface UserSecurity {

    Timestamp getLastPasswordResetDate();
}
