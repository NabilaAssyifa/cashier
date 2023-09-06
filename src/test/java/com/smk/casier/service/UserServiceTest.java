package com.smk.casier.service;

import com.smk.casier.model.User;
import org.junit.jupiter.api.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    @Order(2)
    void getUserList() {
        List<User> userList =
                UserService
                        .getInstance()
                        .getUserList();

                        assertEquals(userList.size(), 1);

    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void addUser() {
        User user = new User();
        user.setUserName("BinaInformatika");
        user.setPassword("R4h4s1a");
        UserService
                .getInstance().addUser(user);
    }
}