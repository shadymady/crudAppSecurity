package web.dao;


import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> printUsers(){
        return entityManager.createQuery("From User user").getResultList();
    }

    @Override
    public User printUserById(int id){
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void save(User user){
        entityManager.persist(user);
    }

    @Override
    public void edit(User user){
        entityManager.merge(user);
    }

    @Override
    public void delete(int id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    //private final Map<String, User> userMap = new HashMap<>();
    @Override
    public User findUserByName(String name) {
       //userMap.put("user",
          //    new User("user", 1, "user", Collections.singleton(new Role(1L, "ROLE_USER"))));
        //userMap.put("admin",
           //   new User("admin", 2, "admin", Collections.singleton(new Role(2L, "ROLE_ADMIN"))));
      //  if (!userMap.containsKey(name)) {
          // return null;
      // }
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.name=:name", User.class);
        query.setParameter("name", name);
       return query.getResultList().stream().findAny().orElse(null);
       //return userMap.get(name);
    }

}
