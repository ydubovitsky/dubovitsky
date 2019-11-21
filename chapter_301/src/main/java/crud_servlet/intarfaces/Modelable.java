package crud_servlet.intarfaces;

import crud_servlet.beans.User;

import java.util.List;

public interface Modelable {

    /**
     * Return all users from database;
     * @return
     */
    List<User> getUsers();

    /**
     * Create new user
     * @return
     */
    void createUser(String name, String login, String password, String email);

    /**
     * Update user fields;
     * @return
     */
    User updateUser();

    /**
     * Delete user from database;
     * @return
     */
    boolean dropUser();
}
