package com.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;
    private Date birthday; // 生日
    private String gender; // 性别
    private String username;
    private String password;
    private String remark; // 备注
    private String station; // 状态
    private String telephone; // 联系电话
    private String role;
    private Set<Role> roles = new HashSet<Role>(0);//对应角色集合

}
