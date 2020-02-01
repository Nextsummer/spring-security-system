package com.exam.mapper;

import com.exam.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    User findByUsername(String username);
}
