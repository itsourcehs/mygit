package tesla.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Classname teslacarDao
 * @Description TODO
 * @Date 2021/12/7 17:05
 * @Created by 123456
 */

@Repository
public class teslacarDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void select(){
        jdbcTemplate.
    }
}
