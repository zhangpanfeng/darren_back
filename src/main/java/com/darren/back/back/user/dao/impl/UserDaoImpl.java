package com.darren.back.back.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.darren.back.back.base.dao.BaseDao;
import com.darren.back.back.user.dao.UserDao;
import com.darren.comm.exception.BusinessException;
import com.darren.comm.user.po.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    public List<User> findAllUsers() throws BusinessException {
        List<User> result = super.findAllEntitys("findAllUsers");

        return result;
    }

    public void saveUser(User user) throws BusinessException {
        super.saveEntity("saveUser", user);
    }

    public User findUserByParams(Map<String, Object> params) throws BusinessException {
        User result = (User) super.findEntityByParams("findUserByParams", params);

        return result;
    }

}
