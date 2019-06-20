package com.auction.service;

import com.auction.model.User;

public interface SecurityService {

    void autologin(String username, String password);

    boolean loginUser(String username, String password);

    User getAuthenticatedUser();

}