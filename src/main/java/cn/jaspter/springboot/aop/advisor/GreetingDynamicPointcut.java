package cn.jaspter.springboot.aop.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：liuyue
 * @date       ：Created in 2021/8/2 10:44
 * @description：动态匹配切点
 * @modified By：
 * @version: 1.0.0$
 */
@Component
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();

    public GreetingDynamicPointcut() {
       super();
    }

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    /**
     * 对类进行静态切点检查
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class clazz) {
                System.out.println("调用getClassFilter()对" + clazz.getName() + "做静态检查.");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

    /**
     * 对方法进行静态切点检查
     */
    @Override
    public boolean matches(Method method, Class clazz) {
        System.out.println("调用matches(method,clazz)对" + clazz.getName() + "." + method.getName() + "做静态检查.");
        return "greetTo".equals(method.getName());
    }

    /**
     * 对方法进行动态切点检查
     */
    public boolean matches(Method method, Class clazz, Object[] args) {
        System.out.println("调用matches(method,clazz)对" + clazz.getName() + "." + method.getName() + "做动态检查.");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }

}
