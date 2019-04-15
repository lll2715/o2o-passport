import com.lfx.business.passport.domain.Account;
import com.lfx.business.passport.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;


/**
 * Created by liufeixiang on 2019/3/20.
 */
@Slf4j
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AccountServiceImplTest {

    @Resource
    private AccountServiceImpl accountServiceImpl;

    @Test
    public void testInject(){
        assertNotNull(accountServiceImpl);
    }

    @Test
    public void testGetAccountByName() throws Exception {
        accountServiceImpl.getAccountByName("accountName");
        accountServiceImpl.getAccountByName("accountName");

        accountServiceImpl.reload();
        log.info("after reload ....");

        accountServiceImpl.getAccountByName("accountName");
        accountServiceImpl.getAccountByName("accountName");
    }

    @Test
    public void addOrUpdateCache(){
        Account account = new Account("124");
        accountServiceImpl.setCache(account);
    }

    @Test
    public void getCache(){
        log.info(accountServiceImpl.getCache().toString());
    }

}
