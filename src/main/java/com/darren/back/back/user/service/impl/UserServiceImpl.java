package com.darren.back.back.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darren.back.back.user.dao.UserDao;
import com.darren.back.back.user.service.UserService;
import com.darren.comm.exception.BusinessException;
import com.darren.comm.user.po.User;
import com.darren.comm.utils.MD5;

/**
 * 用户服务接口实现
 * 
 * @author zhangpanfeng
 * 
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() throws BusinessException {
        List<User> result = userDao.findAllUsers();

        return result;
    }

    public String saveUser(User user) throws BusinessException {
        user.setId(UUID.randomUUID().toString());
        user.setPassword(MD5.md5(user.getPassword()));
        user.setCreateTime(new Date());
        userDao.saveUser(user);
        String result = user.getId();

        return result;
    }

    public User findUserByNameAndPassword(String userName, String password) throws BusinessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("password", MD5.md5(password));
        User result = userDao.findUserByParams(params);

        return result;
    }
}
