package mybatis.generator;

import com.hs.dao.TeslaCarMapper;
import com.hs.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class teslaApplicationTests {

    @Resource
    private TeslaCarMapper mapper;

    @Test
    void contextLoads() {
        System.out.println("t3est");
    }


    @Test
    void testCount(){
        System.out.println(mapper.count());
    }

    @Test
    void testString(){
        System.out.println(StringUtils.getRandomString(6));
    }

}

