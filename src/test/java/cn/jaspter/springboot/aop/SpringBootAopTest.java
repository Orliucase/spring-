package cn.jaspter.springboot.aop;


import cn.jaspter.springboot.aop.advice.AspectConfig;
import cn.jaspter.springboot.aop.advice.ForumService;
import cn.jaspter.springboot.aop.advice.Waiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(AspectConfig.class)
public class SpringBootAopTest {

    @Autowired
    private Waiter waiter;
    @Autowired
    private ForumService forumService;
    @Test
    public void testBeforeAdviceWithCGLib() {
        waiter.greetTo("Tom");
    }
    @Test
    public void testThrowAdvice(){
        forumService.removeForum(1);
    }
}
