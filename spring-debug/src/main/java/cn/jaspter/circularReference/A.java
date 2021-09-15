package cn.jaspter.circularReference;

import org.springframework.stereotype.Component;

/**
 * @author     ：liuyue
 * @date       ：Created in 2021/8/24 17:56
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class A {
    private B b;

    public A() {
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
