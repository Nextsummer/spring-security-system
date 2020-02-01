package com.exam.mapper;

import com.exam.entity.Permission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

@Repository
public interface PermissionMapper extends Mapper<Permission> {
    Set<Permission> findByPermissionId(Integer id);
}
