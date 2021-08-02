package cn.jaspter.springboot.aop.advisor;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author ：liuyue
 * @date ：Created in 2021/8/2 14:11
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class StaticMethodAspectAdvisor implements MethodBeforeAdvice {

    @Autowired
    private StaticMethodAdvisorPointcut staticMethodAdvisor;

    @Bean
    public MethodBeforeAdvice methodBeforeAdvice() {
        return new cn.jaspter.springboot.aop.advisor.StaticMethodAspectAdvisor();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setAdvice(methodBeforeAdvice());
        defaultPointcutAdvisor.setPointcut(staticMethodAdvisor);
        return defaultPointcutAdvisor;
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

    }
}
