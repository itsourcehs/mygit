package tesla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname teslaApplication
 * @Description TODO
 * @Date 2021/12/7 10:36
 * @Created by 123456
 */
@Controller
@Configuration
@SpringBootApplication
public class teslaApplication {
    public static void main(String[] args) {
        SpringApplication.run(teslaApplication.class,args);
    }

    /**
     * @Description Test
     */
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
       return "hello";
    }
}
