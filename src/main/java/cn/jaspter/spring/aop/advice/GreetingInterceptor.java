package cn.jaspter.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    /**
     * 解惑目标类方法的执行,并在前后添加横切逻辑
     *
     * @param methodInvocation 封装了目标方法及其入参,以及目标方法所在的实例对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("How are you！Mr." + clientName + ".");

        Object obj = methodInvocation.proceed();//通过反射调用目标方法

        System.out.println("Please enjoy yourself!");

        return obj;
    }
}
