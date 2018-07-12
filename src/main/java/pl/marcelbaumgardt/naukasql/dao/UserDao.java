package pl.marcelbaumgardt.naukasql.dao;


import org.springframework.stereotype.Repository;
import pl.marcelbaumgardt.naukasql.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(User user){
        entityManager.persist(user);
    }

    //zapytania dynamiczne czyli takie ktore parametryzujemy

    public List<User> getAllUsers() {
        String getAllSql="SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(getAllSql, User.class);
        List<User> resultList = query.getResultList();
        return resultList;
    }

    public void deleteAll(){
        String deleteAllSql="DELETE FROM User u";
        Query query = entityManager.createQuery(deleteAllSql);
        query.executeUpdate();
    }

    public List<User> customGetQquery(String sqlka){
        TypedQuery<User> query = entityManager.createQuery(sqlka, User.class);
        List<User> resultList = query.getResultList();
        return resultList;
    }

    public void customDeleteQquery(String sqlka){
        Query query = entityManager.createQuery(sqlka);
        query.executeUpdate();
    }
}
