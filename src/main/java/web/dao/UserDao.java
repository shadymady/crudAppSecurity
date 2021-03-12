package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> printUsers();

    void save(User user);

    void delete(Long id);

    void edit(User user);

    User printUserById(Long id);

    public User findUserByName(String firstName);

}
