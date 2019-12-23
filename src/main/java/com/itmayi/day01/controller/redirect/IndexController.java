package com.itmayi.day01.controller.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {


    @RequestMapping("/loginPage")
    public String login(){
        return "loginPage";
    }

    //自定义重定向1
    @RequestMapping("/customRedirection")
    public void customRedirection(HttpServletResponse response){
        //通知客户端重定向
        response.setStatus(302);
        response.setHeader("location", "loginPage");
    }

    //自定义重定向1
    @RequestMapping("/redirectloginPage")
    public String redirectLogin(){
        //通知客户端重定向
       return "redirect:/loginPage";
    }




    // 登陆返回json格式
    @PostMapping(value = "/loginJSON")
    @ResponseBody
    public String login(String userName, String passWord) {
        System.out.println("userName:" + userName + ",passWord:" + passWord);
        return "userName:" + userName + ",passWord:" + passWord;
    }
}
