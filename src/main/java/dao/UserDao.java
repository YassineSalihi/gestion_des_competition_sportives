package dao;

import org.entities.User;
import org.hibernate.Session;
import util.HibernateUtil;


public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }

    @Override
    public boolean create(User user) {
        // Ici, on enregistre le mot de passe tel quel (⚠️ pas sécurisé)
        return super.create(user);
    }

    public boolean checkPassword(String plainPassword, String storedPassword) {
        // Comparaison simple (⚠️ pas sécurisé non plus)
        return plainPassword.equals(storedPassword);
    }

    public User findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}
