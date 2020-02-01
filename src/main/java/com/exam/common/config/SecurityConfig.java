package com.exam.common.config;
import com.exam.controller.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //默认关闭，不开启则无法使注解生效
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService ());
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则

        http.authorizeRequests().antMatchers("/","/userLogin").permitAll()
                .anyRequest().authenticated();

        // 配置登录功能
        http.formLogin().usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userLogin");
        // 注销成功跳转首页
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
        //
        http.csrf().disable();
    }


    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailService())
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public UserDetailServiceImpl userDetailService (){
        return new UserDetailServiceImpl () ;
    }
    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
