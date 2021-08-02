package cn.jaspter.springboot.aop.advisor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass =false)
@ComponentScan("cn.jaspter.springboot.aop.advisor")
public class AspectConfig {
}
