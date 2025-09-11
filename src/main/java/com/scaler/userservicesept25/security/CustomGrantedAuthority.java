package com.scaler.userservicesept25.security;

import com.scaler.userservicesept25.models.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;

    public CustomGrantedAuthority(Role role) {
        this.authority = role.getRoleName();
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
