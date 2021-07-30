package cn.jaspter.spring.ioc;

import cn.jaspter.spring.ioc.service.IUserService;
import cn.jaspter.spring.ioc.springContext.SpringContext;

public class IocTest {

    public static void main(String[] args)throws Exception {
        String path = "cn.jaspter.ioc.service.impl";
        SpringContext context = new SpringContext(path);
        IUserService userService = (IUserService) context.getBean("userbiz");
        System.out.println(userService.findOrder("lyl"));
    }

}
