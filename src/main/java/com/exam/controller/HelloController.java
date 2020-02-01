package com.exam.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    /**
     * 首页
     */
    @RequestMapping("/")
    public String index (){
        return "home" ;
    }
    /**
     * 登录页
     */
    @RequestMapping("/userLogin")
    public String loginPage (){
        return "pages/login" ;
    }
    /**
     * 登录页
     */
    @RequestMapping("/500")
    public String serverError (){
        return "500" ;
    }


    @RequestMapping("/403")
    public String forbidden() {
        return "403";
    }
    /**
     * page1 下页面
     */
    @PreAuthorize("hasAuthority('KNOWLEDGE_ADD')")
    @RequestMapping("/page1/{pageName}")
    public String onePage (@PathVariable("pageName") String pageName){
        return "pages/page1/"+pageName ;
    }
    /**
     * page2 下页面
     */
    @PreAuthorize("hasAuthority('KNOWLEDGE_DELETE')")
    @RequestMapping("/page2/{pageName}")
    public String twoPage (@PathVariable("pageName") String pageName){
        return "pages/page2/"+pageName ;
    }
    /**
     * page3 下页面
     */
    @PreAuthorize("hasAuthority('KNOWLEDGE_EDIT')")
    @RequestMapping("/page3/{pageName}")
    public String threePage (@PathVariable("pageName") String pageName){
        return "pages/page3/"+pageName ;
    }
}
