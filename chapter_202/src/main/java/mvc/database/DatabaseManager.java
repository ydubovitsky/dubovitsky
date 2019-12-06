package mvc.database;

import mvc.beans.User;
import mvc.intarfaces.Connectable;

import java.sql.*;
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
            //TODO а проверка? Если множество пустое? ТУТ ОШИБКА! ВОЗВРАЩАЕТ ПУСТОЙ ЛИСТ
            while (resultSet.next()){
                users.add(createUser(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getTime(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Added new user in database and current timeStamp;
     */
    public void addUser(String name, String login, String password, String email) {
        try {
            String sql = "insert into users(name, login, password, email, createdate) values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            statement.execute();
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

    public static void main(String[] args) {
        new DatabaseManager(new ConnectionDataBase()).addUser("Mordekay", "morda123", "efef23", "dr_mo@mail.ru");
    }
}
