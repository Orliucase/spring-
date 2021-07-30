package cn.jaspter.spring.ioc.annoation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IocResource {

}
