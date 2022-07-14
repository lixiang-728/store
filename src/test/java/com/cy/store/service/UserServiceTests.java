package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

// @SpringBootTest：表示标注当前的类是测试类，不会随同项目一块打包
@SpringBootTest
class UserServiceTests {
    // idea有检测功能，接口是不能直接创建Bean的（动态代理技术解决）
    @Autowired
    private IUserService userService;

    /**
     * 单元测试方法：可以单独独立运行
     * 1.必须被Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法修饰符必须是public
     */
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("test1");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            // 获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        User user = userService.login("haha", "123");
        System.out.println(user);
    }

    @Test
    public void changePassword() {
        userService.changePassword(15, "管理员", "321", "123");
    }

    @Test
    public void getByUid() {
        User user = userService.getByUid(16);
        System.out.println(user);
    }

    @Test
    public void changeInfo() {
        User user = new User();
        user.setPhone("110");
        user.setEmail("110@qq.com");
        user.setGender(0);
        userService.changeInfo(16, "管理员",user);
    }

    @Test
    public void changeAvatar() {
        userService.changeAvatar(16, "/upload/avatar/1.png","用户甲");
    }

}