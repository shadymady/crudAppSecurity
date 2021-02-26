
package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> printUsers();

    void save(User user);

    void delete(int id);

    void edit(User user);

    User printUserById(int id);

    User findUserByName(String name);
}