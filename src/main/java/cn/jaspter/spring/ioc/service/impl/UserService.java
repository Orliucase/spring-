package cn.jaspter.spring.ioc.service.impl;

import cn.jaspter.spring.ioc.annoation.IocResource;
import cn.jaspter.spring.ioc.annoation.IocService;
import cn.jaspter.spring.ioc.service.IOrderService;
import cn.jaspter.spring.ioc.service.IUserService;

@IocService(name = "userbiz")
public class UserService implements IUserService {
    /*比较脆弱啊 这块的属性名称一定要用实现类来命名 且 按照第一个字母要小写的原则 否则很报错的*/
    @IocResource
    private IOrderService orderService;
    @Override
    public String findOrder(String username) {
        return orderService.findOrder(username);
    }
}
