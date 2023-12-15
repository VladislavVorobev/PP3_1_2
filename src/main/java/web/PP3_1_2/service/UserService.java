package web.PP3_1_2.service;


import web.PP3_1_2.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    List<User> getUserTable();
    User findUser(long id);
}