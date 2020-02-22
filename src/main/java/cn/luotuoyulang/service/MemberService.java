package cn.luotuoyulang.service;

import org.springframework.stereotype.Service;

/**
 * @Classname MemberService
 * @Description TODO
 * @Date 2020/2/21 18:19
 * @Created by liuyuhu
 */
@Service
public class MemberService {

    public String getMember(){
        try {
            Thread.sleep(1000);
            System.out.println("第二部。。。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "memberService   调用成功";
    }

}
