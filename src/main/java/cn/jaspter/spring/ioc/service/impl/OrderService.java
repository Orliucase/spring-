package cn.jaspter.spring.ioc.service.impl;

import cn.jaspter.spring.ioc.annoation.IocService;
import cn.jaspter.spring.ioc.service.IOrderService;

@IocService
public class OrderService implements IOrderService {
    @Override
    public String findOrder(String username) {
        return "用户"+username+"的订单编号是:1001";
    }
}
