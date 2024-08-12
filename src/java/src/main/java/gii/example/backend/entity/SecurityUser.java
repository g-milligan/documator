package gii.example.backend.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {

    private UserEntity user;

    public SecurityUser(UserEntity givenUser) {
        this.user = givenUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_" + this.user.getUserGroup().toString()));
        return list;
    }

    @Override
    public String getPassword() {
        return this.user.getUserPwd();
    }

    @Override
    public String getUsername() {
        return this.user.getUserEmail();
    }
    
}
