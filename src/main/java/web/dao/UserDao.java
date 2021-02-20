package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> printUsers();

    void save(User user);

    void delete(int id);

    void edit(User user);

    User printUserById(int id);

}
