package com.authservices.authservices.sec.service;


import com.authservices.authservices.sec.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=accountService.loadUserByUserName(username);

         //Methode 1
            /*    Collection<GrantedAuthority> authorities=new ArrayList<>();
                appUser.getAppRoles().forEach(r->{
                    authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                });*/

        //Methode 2
        Collection<GrantedAuthority> authorities=
                appUser.getAppRoles()
                        .stream()
                        .map(r->new SimpleGrantedAuthority(r.getRoleName())).
                        collect(Collectors.toList());
        User user=new User(appUser.getUsername(), appUser.getPassword(),authorities);
        return user;
    }
}
