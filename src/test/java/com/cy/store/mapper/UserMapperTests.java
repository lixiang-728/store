package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

// @SpringBootTest：表示标注当前的类是测试类，不会随同项目一块打包
@SpringBootTest
class UserMapperTests {
    // idea有检测功能，接口是不能直接创建Bean的（动态代理技术解决）
    @Autowired
    private UserMapper userMapper;
    /**
     * 单元测试方法：可以单独独立运行
     * 1.必须被Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法修饰符必须是public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim2");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUserName(){
        User user = userMapper.findByUsername("tim");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){

        userMapper.updatePasswordByUid(14,"321",
                "管理员",new Date());
    }


    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(12));
    }

    @Test
    public void updateInfoById(){
        User user = new User();
        user.setUid(16);
        user.setPhone("12123342");
        user.setEmail("121233@qq.com");
        user.setGender(1);
        userMapper.updateInfoById(user);
    }

    @Test
    public void updateAvatarById(){
        userMapper.updateAvatarByUid(
                16,
                "/upload/avatar",
                "管理员",
                new Date());
    }
}
