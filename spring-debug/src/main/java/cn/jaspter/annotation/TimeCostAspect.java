package cn.jaspter.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author ：liuyue
 * @date ：Created in 2021/9/15 15:45
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@Aspect
public class TimeCostAspect {

    @Pointcut("@annotation(cn.jaspter.annotation.TimeCostAnnotation)")
    public void pointCut(){

    }
    @Around("pointCut()")
    public Object logArount(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start();
        String clsaaName = joinPoint.getTarget().getClass().getName();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String method = methodSignature.getName();
        String service = clsaaName +"."+method;
        Object[] args = joinPoint.getArgs();
        System.out.println("开始进入服务"+service);
        for(Object o : args){
            if(o instanceof String){
                System.out.println(o.toString());
            }
        }
        Object proceed = joinPoint.proceed();
        watch.stop();
        System.out.println("执行服务结束，用时"+watch.getTotalTimeSeconds());
        return proceed;
    }
}
