package cn.jaspter.springboot.aop.advisor;

import org.springframework.stereotype.Component;

@Component
public class Waiter {

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serving " + name + "...");
    }
}
