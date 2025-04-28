package services;

import dao2.UserDao;
import org.entities.User;

import java.util.List;

public class UserService {

    private UserDao dao = new UserDao();

    public void create(User u) {
        dao.create(u);
    }

    public void update(User u) {
        dao.update(u);
    }

    public void delete(User u) {
        dao.delete(u);
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
