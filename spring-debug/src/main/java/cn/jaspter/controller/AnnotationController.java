package cn.jaspter.controller;

import cn.jaspter.annotation.TimeCostAnnotation;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liuyue
 * @date ：Created in 2021/9/15 15:53
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@EnableAsync
public class AnnotationController {
    @TimeCostAnnotation
    @GetMapping("/annotation")
    public String test(){
        System.out.println("测试自定义注解实现");
        return "false";
    }
}
