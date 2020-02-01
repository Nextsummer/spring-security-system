package com.exam.mapper;

import com.exam.entity.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

@Repository
public interface RoleMapper extends Mapper<Role> {
    Set<Role> findByRoleId(Integer userId);
}
