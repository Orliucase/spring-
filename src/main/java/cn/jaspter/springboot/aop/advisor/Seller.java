package cn.jaspter.springboot.aop.advisor;

import org.springframework.stereotype.Component;

@Component
public class Seller {
    public void greetTo(String name) {
        System.out.println("seller greet to " + name + "...");
    }
}
