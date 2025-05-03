package dao2;

import org.entities.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class UserDao extends AbstractDao<User> {
    public UserDao() {
        super(User.class);
    }

    public User findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    public User findByEmailAndPassword(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM User u WHERE u.email = :email AND u.motDePasse = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();
        }
    }
}
