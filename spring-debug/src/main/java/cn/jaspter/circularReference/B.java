package cn.jaspter.circularReference;

import org.springframework.stereotype.Component;

/**
 * @author ：liuyue
 * @date ：Created in 2021/8/24 17:56
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class B {
    private A a;

    public B() {
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
