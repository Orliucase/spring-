package cn.jaspter.springboot.aop.advisor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author     ：liuyue
 * @date       ：Created in 2021/7/31 11:59
 * @description：advisor切面
 * @modified By：
 * @version: 1.0.0$
 */
@Aspect
@Component
public class AdvisorAspect {
    @Pointcut("execution(* cn.jaspter.springboot.aop.advisor.Waiter.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getTarget().getClass().getName();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String methodName = methodSignature.getName();
        System.out.println(className + ":" + methodName);
        System.out.println("***********before   " + args[0]);
    }

    @After("pointCut()")
    public void after() {
        System.out.println("***********after");
    }
}
