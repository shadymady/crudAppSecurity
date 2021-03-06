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
    public User printUserById(Long id){
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
    public void delete(Long id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    @Override
    public User findUserByName(String firstName) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.firstName=:firstName", User.class);
        query.setParameter("firstName", firstName);

        return query.getResultList().stream().findAny().orElse(null);
    }

}
