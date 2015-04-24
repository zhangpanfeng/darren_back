package com.darren.back.client.user.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.darren.back.back.user.service.UserService;
import com.darren.comm.client.user.service.UserClientService;
import com.darren.comm.exception.BusinessException;
import com.darren.comm.user.po.User;
import com.darren.comm.vo.ResultHandle;

/**
 * 用户远程服务接口的实现
 * 
 * @author zhangpanfeng
 * 
 */
@Component("userClientServiceRemote")
public class UserClientServiceImpl implements UserClientService {
    private static final Log LOG = LogFactory.getLog(UserClientServiceImpl.class);
    /**
     * 注入用户服务
     */
    @Autowired
    private UserService userService;

    public ResultHandle<List<User>> findAllUsers() {
        ResultHandle<List<User>> resultHandle = new ResultHandle<List<User>>();
        try {
            List<User> userList = userService.findAllUsers();
            resultHandle.setContent(userList);
        } catch (BusinessException e) {
            LOG.error("Error method <findAllUsers>");
            LOG.error(e);
            resultHandle.setErrorCode(e.getErrorCode());
            resultHandle.setMessage(e.getMessage());
            resultHandle.setSuccess(false);
        }

        return resultHandle;
    }

    public ResultHandle<String> saveUser(User user) {
        ResultHandle<String> resultHandle = new ResultHandle<String>();
        try {
            String userId = userService.saveUser(user);
            resultHandle.setContent(userId);
        } catch (BusinessException e) {
            LOG.error("Error method <saveUser>");
            LOG.error(e);
            resultHandle.setErrorCode(e.getErrorCode());
            resultHandle.setMessage(e.getMessage());
            resultHandle.setSuccess(false);
        }

        return resultHandle;
    }

    public ResultHandle<User> findUserByNameAndPassword(String userName, String password) {
        ResultHandle<User> resultHandle = new ResultHandle<User>();
        try {
            User user = userService.findUserByNameAndPassword(userName, password);
            resultHandle.setContent(user);
        } catch (BusinessException e) {
            LOG.error("Error method <findUserByNameAndPassword>");
            LOG.error(e);
            resultHandle.setErrorCode(e.getErrorCode());
            resultHandle.setMessage(e.getMessage());
            resultHandle.setSuccess(false);
        }

        return resultHandle;
    }

}
