package com.exam.controller;

import com.exam.entity.Permission;
import com.exam.entity.Role;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.exam.entity.User user = userService.findByUsername(username);
        if (user == null){
            return null;
        }

//         * Spring Boot 2.0 版本踩坑
//         * 使用用户必须要 ROLE_ 前缀， 因为 hasRole("USER")判断时会自动加上ROLE_前缀变成 ROLE_USER ,
//         * 如果不加前缀一般就会出现403错误
//         * 在给用户赋权限时,数据库存储必须是完整的权限标识ROLE_USER

        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for(Role role : roles){
            Set<Permission> permissions = role.getPermissions();
            for(Permission permission : permissions){
                authorities.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }
        return new User(username,user.getPassword(),authorities);
    }
}