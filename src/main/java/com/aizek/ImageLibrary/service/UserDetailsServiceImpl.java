package com.aizek.ImageLibrary.service;

import java.util.ArrayList;
import java.util.List;

import com.aizek.ImageLibrary.repo.UserRepository;
import com.aizek.ImageLibrary.models.User;
import com.aizek.ImageLibrary.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private RoleRepository RoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User User = this.UserRepository.findUserAccount(userName);

        if (User == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + User);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.RoleRepository.getRoleNames(User.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(User.getUserName(), //
                User.getEncryptedPassword(), grantList);

        return userDetails;
    }

}
