package com.exam.service.impl;

import com.exam.entity.Permission;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.mapper.PermissionMapper;
import com.exam.mapper.RoleMapper;
import com.exam.mapper.UserMapper;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user == null){
            return null;
        }

        Set<Role> roles = roleMapper.findByRoleId(user.getId());
        if (roles != null && roles.size() > 0){
            for (Role role : roles) {
                Set<Permission> permissions = permissionMapper.findByPermissionId(role.getId());
                if (permissions != null && permissions.size() > 0) {
                    role.setPermissions(permissions);
                }
            }
            user.setRoles(roles);
        }
        return user;
    }
}
