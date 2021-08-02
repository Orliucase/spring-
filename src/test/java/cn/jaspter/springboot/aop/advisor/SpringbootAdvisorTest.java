package cn.jaspter.springboot.aop.advisor;/**
 * @author ：mmzs
 * @date ：Created in 2021/7/30 17:53
 * @description：advisor测试
 * @modified By：
 * @version: 1.0.0$
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author     ：liuyue
 * @date       ：Created in 2021/7/30 17:53
 * @description：advisor测试
 * @modified By：
 * @version: 1.0.0$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(AspectConfig.class)
public class SpringbootAdvisorTest {

    @Autowired
    private Waiter waiter;
    @Autowired
    private Seller seller;

    /**
     * 正常切面
     */
    @Test
    public void testAdvisor(){
        waiter.greetTo("Tom");
    }


    /**
     * 正则匹配切面
     */
    @Test
    public void testRegexpAdvisor() {
        waiter.greetTo("Tom");
        seller.greetTo("Jenny");
    }

    @Test
    public void testDynamicAdvisor(){
        waiter.greetTo("Tom");
    }



}
