package cn.jaspter;

import cn.jaspter.springboot.aop.advice.NaiveWaiter;
import cn.jaspter.springboot.aop.advice.Waiter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplication {
    public static void main(String[] args) {
        Waiter target = new NaiveWaiter();
        target.greetTo("Tom");
    }
}
