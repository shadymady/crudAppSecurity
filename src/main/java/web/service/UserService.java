
package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> printUsers();

    void save(User user);

    void delete(Long id);

    void edit(User user);

    User printUserById(Long id);

    User findUserByName(String firstName);
}