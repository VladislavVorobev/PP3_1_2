package web.PP3_1_2.dao;


import web.PP3_1_2.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    User findUser(long id);
    List<User> getUserTable();

}
