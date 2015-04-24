package com.darren.back.user.client.service.impl;

import org.springframework.stereotype.Component;

import com.darren.comm.user.client.service.UserClientService;

@Component("userClientServiceRemote")
public class UserClientServiceImpl implements UserClientService {

    public String test() {
        return "Darren";
    }

}
