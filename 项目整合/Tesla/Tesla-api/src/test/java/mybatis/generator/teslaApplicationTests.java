package mybatis.generator;

import mybatis.generator.dao.TeslaCarMapper;
import mybatis.generator.entity.TeslaCarExample;
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
    long testCount(){
        return mapper.count();
    }

}

