package cn.luotuoyulang.controller;

import cn.luotuoyulang.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class IndexController {

    @Autowired
    MemberService memberService;

    @ResponseBody
    @GetMapping(value = "/",produces = "text/html;charset=utf-8")
    public String testIndex(){
        return "Hello World !!!! index  ！！！ 船只波i可";
    }


//    @Async
    @GetMapping("/payIndex")
    public String pay(){
        System.err.println("*****************************pay");
        return "payIndex";
    }

    @ResponseBody
    @GetMapping("/member")
    public Callable<String> member(){
        System.err.println("第一步。。。。。。。。。");
        Callable stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                String member = memberService.getMember();
                return member;
            }
        };
        System.err.println("第三步。。。。。。。。。。");
        return stringCallable;
    }
}
