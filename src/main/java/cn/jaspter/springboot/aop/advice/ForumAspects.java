package cn.jaspter.springboot.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ForumAspects {
    @Pointcut("execution(* cn.jaspter.springboot.aop.advice.Waiter.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getTarget().getClass().getName();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String methodName = methodSignature.getName();
        System.out.println(className + ":" + methodName);
        System.out.println("***********before"+ args[0]);
    }

    @After("pointCut()")
    public void after(){
        System.out.println("***********after");
    }
    @Around("execution(* cn.jaspter.springboot.aop.advice.Waiter.*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("@Around：执行目标方法之前...");
        //访问目标方法的参数：
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "Dom";
        }
        //用改变后的参数执行目标方法
        Object returnValue = point.proceed(args);
        System.out.println("@Around：执行目标方法之后...");
        System.out.println("@Around：被织入的目标对象为：" + point.getTarget());
        return "原返回值：" + returnValue + "，这是返回结果的后缀";
    }

    @AfterReturning(pointcut="execution(* cn.jaspter.springboot.aop.advice.Waiter.*(..))",
            returning="returnValue")
    public void log(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" +
                Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning：返回值为：" + returnValue);
        System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());

    }


}
