///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package example.todolist.jdbc;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author kamwa
// */
//@Controller
//@RequestMapping("/login")
//public class WebController {
//
//    @GetMapping("")
//    public String login() {
//        return "todo";
//    }
//}
package example.todolist.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("todo");
        registry.addViewController("/todo").setViewName("todo");
        registry.addViewController("/login").setViewName("login");
    }
}