import com.lfx.business.passport.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;


/**
 * Created by liufeixiang on 2019/3/20.
 */
@Slf4j
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AccountServiceImplTest2 {

    @Autowired
    private AccountService accountService2;

    @Test
    public void testInject(){
        assertNotNull(accountService2);
    }

    @Test
    public void testGetAccountByName() throws Exception {
        long start = System.currentTimeMillis();
        log.info("first query...");
        accountService2.getAccountByName("ccccc");
        log.info("second query...");
        accountService2.getAccountByName("ccccc");
        long end = System.currentTimeMillis();
        System.out.println("Total Time:" + (end - start) + "ms");
    }

    @Test
    public void reload(){
        accountService2.reload();
    }
}
