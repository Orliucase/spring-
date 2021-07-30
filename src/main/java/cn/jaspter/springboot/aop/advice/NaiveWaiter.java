package cn.jaspter.springboot.aop.advice;

import org.springframework.stereotype.Component;

@Component
public class NaiveWaiter implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("I am "+ name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("I am "+ name);
    }
}
