package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }
    @Override
    public void createUsersTable() {
//        String query = "CREATE TABLE IF NOT EXISTS users" +
//                "(id bigint, name text, lastName text, age tinyint);";
//        try (Session session = Util.getSessionFactory().openSession();) {
//            session.beginTransaction();
//            session.createSQLQuery(query);
//            session.getTransaction().commit();
//        }
    }

    @Override
    public void dropUsersTable() {

    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try (Session session = Util.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession();) {
            session.beginTransaction();

            users = session.createQuery("from User").list();

            session.getTransaction().commit();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {

    }
}
