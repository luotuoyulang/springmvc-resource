package cn.luotuoyulang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String testIndex(){
        return "Hello World !!!! index";
    }
}
