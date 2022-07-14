package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 用户模块的持久层接口
 * */

public interface UserMapper {
    /**
     * 插入用户数据
     * @param user  用户的数据
     * @return  影响的行数（增删改都受影响的行数作为返回值，可以根据返回值来判断是否执行）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username  用户名
     * @return  如果找到对应的用户则返回对应的数据，否则返回null
     */
    User findByUsername(String username);

    /**
     * *  根据用户的uid来修改用户密码
     * @param uid   用户的uid
     * @param password  用户输入的新密码
     * @param modifiedUser  表示修改的执行者
     * @param modifiedTime  数据修改的时间
     * @return   受影响的行数
     */

    Integer updatePasswordByUid(@Param("uid") Integer uid,@Param("password") String password,
                                @Param("modifiedUser")String modifiedUser, @Param("modifiedTime")Date modifiedTime);

    /**
     *  根据用户的id查询用户的数据
     * @param uid   用户的id
     * @return  找到返回对象，反之返回null
     */
    User findByUid(Integer uid);

    /**
     *  更新用户的数据信息
     * @param user  用户的数据
     * @return  影响的行数
     */
    Integer updateInfoById(User user);

    /**
     *  根据用户的uid修改用户的头像
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid( @Param("uid")Integer uid,  @Param("avatar")String avatar,
                              @Param("modifiedUser")String modifiedUser, @Param("modifiedTime")Date modifiedTime);
}
