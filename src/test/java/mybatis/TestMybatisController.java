package mybatis;

import com.lfx.business.passport.service.TestMybatisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author liufeixiang
 * @date 2019-05-15 09:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/applicationContext.xml"})
@WebAppConfiguration
public class TestMybatisController {

    @Autowired
    private TestMybatisService testMybatisService;

    @Test
    public void test(){
        System.out.println(testMybatisService.selectByCondition());
    }
}
