import com.lfx.business.passport.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by liufeixiang on 2019/3/21.
 */
@Slf4j
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test(){
        log.info("redis test start ...");
        redisUtil.set("abc","1243");
    }
}
