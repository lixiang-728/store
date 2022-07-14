package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }


    /**
     * 数据库连接池
     * HikariProxyConnection@1014278669 wrapping com.mysql.cj.jdbc.ConnectionImpl@6c841199
     * @throws SQLException
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
