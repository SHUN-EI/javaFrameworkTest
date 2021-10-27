package com.mo.mysql.dao;

import com.mo.mysql.domain.User;

import java.util.List;

/**
 * Created by mo on 2021/10/27
 */
public interface UserDao {

    /**
     * 向数据库中保存一个新用户
     *
     * @param user 要保存的用户对象
     * @return 是否增加成功
     */
    Boolean add(User user);

    /**
     * 更新数据库中的一个用户
     *
     * @param user 要更新的用户对象
     * @return 是否更新成功
     */
    Boolean update(User user);

    /**
     * 删除一个指定的用户
     *
     * @param id 要删除的用户的标识
     * @return 是否删除成功
     */
    Boolean delete(Long id);

    /**
     * 精确查询一个指定的用户
     *
     * @param id 要查询的用户的标识
     * @return 如果能够查询到，返回用户信息，否则返回 null
     */
    User queryById(Long id);

    /**
     * 通过名称模糊查询用户
     *
     * @param name 要模糊查询的名称
     * @return 查询到的用户列表
     */
    List<User> queryUserByName(String name);


}
