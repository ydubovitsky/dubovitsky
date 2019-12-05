package crud_servlet;

import crud_servlet.entity.Users;
import crud_servlet.layouts.Logic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class implements database logic.
 */
public class ValidateService implements Logic {

    private StandardServiceRegistry registry;
    private Session session;
    private SessionFactory sessionFactory;
    /**
     * Simple logger
     */
    public Logger logger = Logger.getLogger(ValidateService.class.getCanonicalName());

    /**
     * Register service
     */
    public ValidateService() {
        registry = new StandardServiceRegistryBuilder().configure().build();
    }

    /**
     * Add user in database
     * @param name - user name.
     */
    @Override
    public void add(String name) {
        //TODO Оставить Автозакрытие ресурсов или сделать как в других методах?
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Users user = new Users();
            user.setName(name);
            session.save(user);
            session.getTransaction().commit();
        }
    }

    /**
     * Update user fields
     * @param id - user_s id
     * @param name - new user name
     */
    @Override
    public void update(int id, String name) {
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();

            // Creating Transaction Entity
            Users user = (Users) session.get(Users.class, id);
            user.setName(name);

            // Committing The Transactions To The Database
            session.getTransaction().commit();
            logger.info("\nStudent With Id?= " + id + " Is Successfully Updated In The Database!\n");
        } catch(Exception sqlException) {
            if(null != session.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    /**
     * Delete user from database by id
     * @param id
     */
    @Override
    public void delete(int id) {
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();

            Users user = (Users)session.load(Users.class,id);
            session.delete(user);

            //This makes the pending delete to be done
            session.flush();

            // Committing The Transactions To The Database
            session.getTransaction().commit();
            logger.info("\nStudent With Id?= " + id + " Is Successfully Deleted From The Database!\n");
        } catch(Exception sqlException) {
            if(null != session.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    /**
     * Show all users from database
     * @return
     */
    @Override
    public List displayRecords() {
        List<Users> studentsList = new ArrayList();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            //TODO Почему crud_servlet.entity.Users
            studentsList = session.createQuery("FROM crud_servlet.entity.Users").list();
        } catch(Exception sqlException) {
            if(null != session.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return studentsList;
    }
}
