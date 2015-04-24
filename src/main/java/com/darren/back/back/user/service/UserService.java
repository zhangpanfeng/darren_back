package com.darren.back.back.user.service;

import java.util.List;

import com.darren.comm.exception.BusinessException;
import com.darren.comm.user.po.User;

/**
 * 用户服务接口
 * 
 * @author zhangpanfeng
 * 
 */
public interface UserService {
    /**
     * 查询所有的用户
     * 
     * @return 所有的用户
     * @throws BusinessException
     */
    List<User> findAllUsers() throws BusinessException;

    /**
     * 创建用户
     * 
     * @param user
     *            用户信息
     * @return 用户ID
     * @throws BusinessException
     */
    String saveUser(User user) throws BusinessException;

    /**
     * 根据用户名和密码查用户
     * 
     * @param userName
     *            用户名
     * @param password
     *            密码
     * @return 用户信息
     */
    User findUserByNameAndPassword(String userName, String password) throws BusinessException;
}
