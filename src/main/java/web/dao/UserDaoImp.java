package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
}
