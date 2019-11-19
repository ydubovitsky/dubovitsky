package crud_servlet.database;

import crud_servlet.beans.User;
import crud_servlet.intarfaces.Connectable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    /**
     * Constructor
     * @param cd
     */
    public DatabaseManager(Connectable cd) {
        this.connection = cd.getConnection();
    }

    /**
     * Connection to dataBase;
     */
    private Connection connection;

    /**
     * This method return all users from database
     * @return
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from users");
            //TODO а проверка? Если множество пустое?
            do {
                users.add(createUser(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getTime(6)));
            } while (resultSet.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(int id, String name, String login, String password, String email, Time time) {
        try {
            Statement statement = connection.createStatement();
            //TODO Дописать метод! И сделать чтобы id автоматически создавался при добавлении пользователя
            statement.execute("insert into users(id, name, login) values (1,2,3)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This private method gets User from database and create implementation of this User in java object;
     */
    private User createUser(int id, String name, String login, String password, String email, Time time) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setCreateDate(time);
        return user;
    }
}
