package crud_servlet;

import crud_servlet.beans.User;
import crud_servlet.database.ConnectionDataBase;
import crud_servlet.database.DatabaseManager;
import crud_servlet.intarfaces.Connectable;
import crud_servlet.intarfaces.Modelable;

import java.sql.Time;
import java.util.List;

public class ModelImpl implements Modelable {

    private DatabaseManager databaseManager;

    //TODO Все сложно, много связующего кода! И плохо, что в конструкторе сразу создается объект
    // Может фабрику применить?
    public ModelImpl() {
        Connectable connectable = new ConnectionDataBase();
        databaseManager = new DatabaseManager(connectable);
    }

    @Override
    public List<User> getUsers() {
        return databaseManager.getAllUsers();
    }

    @Override
    public void createUser(int id, String name, String login, String password, String email, Time time) {
        databaseManager.addUser(id, name, login, password, email, time);
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public boolean dropUser() {
        return false;
    }
}
