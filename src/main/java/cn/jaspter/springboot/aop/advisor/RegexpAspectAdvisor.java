package cn.jaspter.springboot.aop.advisor;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author ：liuyue
 * @date ：Created in 2021/8/2 9:50
 * @description：\
 * @modified By：
 * @version: $
 */
@Configuration
public class RegexpAspectAdvisor implements MethodBeforeAdvice {

    @Bean
    public MethodBeforeAdvice methodBeforeAdvice() {
        return new cn.jaspter.springboot.aop.advisor.RegexpAspectAdvisor();
    }

    /**
     * pattern 可以使用通配符匹配切面
     * @return
     */
//    @Bean
//    public RegexpMethodPointcutAdvisor RegexpMethodPointcutAdvisor() {
//        RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor = new RegexpMethodPointcutAdvisor();
//        regexpMethodPointcutAdvisor.setPattern("cn.jaspter.springboot.aop.advisor.*.greetTo");
//        regexpMethodPointcutAdvisor.setAdvice(methodBeforeAdvice());
//        return regexpMethodPointcutAdvisor;
//    }

    /**
     * NameMatchMethodPointcutAdvisor 通过匹配方法名字实现方法增强
     * setMappedNames 方法名字表达式
     * setAdvice 增强方法切面
     * @return
     */
    @Bean
    public NameMatchMethodPointcutAdvisor nameMatchMethodPointcut(){
        NameMatchMethodPointcutAdvisor nameMatchMethodPointcut = new NameMatchMethodPointcutAdvisor();
        nameMatchMethodPointcut.setMappedNames("greet*");
        nameMatchMethodPointcut.setAdvice(methodBeforeAdvice());
        return  nameMatchMethodPointcut;
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("我是一个前置增强。。。。。"+method.getName());
    }
}
