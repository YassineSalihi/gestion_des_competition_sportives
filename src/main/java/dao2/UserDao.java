package dao2;

import org.entities.User;

public class UserDao extends AbstractDao<User> {
    public UserDao() {
        super(User.class);
    }
}
