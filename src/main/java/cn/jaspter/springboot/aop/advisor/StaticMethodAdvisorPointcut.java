package cn.jaspter.springboot.aop.advisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author     ：liuyue
 * @date       ：Created in 2021/8/2 14:06
 * @description：静态切点切入
 * @modified By：
 * @version: 1.0.0$
 */
@Configuration
public class StaticMethodAdvisorPointcut extends StaticMethodMatcherPointcutAdvisor {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("静态方法切入"+method.getName());
        return true;
    }
//    public ClassFilter getClassFilter() {
//        return new ClassFilter() {
//            public boolean matches(Class clazz) {
//                return Waiter.class.isAssignableFrom(clazz);
//            }
//        };
//
//    }

}
