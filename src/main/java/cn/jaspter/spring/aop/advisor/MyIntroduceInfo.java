package cn.jaspter.spring.aop.advisor;

import cn.jaspter.spring.aop.introduce.Monitorable;
import org.springframework.aop.support.IntroductionInfoSupport;

public class MyIntroduceInfo extends IntroductionInfoSupport {
    public MyIntroduceInfo() {
        super();
        super.publishedInterfaces.add(Monitorable.class);
    }
}
