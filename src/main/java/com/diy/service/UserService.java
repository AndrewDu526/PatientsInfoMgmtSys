package com.diy.service;

import com.diy.pojo.User;

public interface UserService {

    public User login(String username, String password);

    public boolean register(User user);

}
