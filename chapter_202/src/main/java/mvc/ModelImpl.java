package mvc;

import mvc.beans.User;
import mvc.database.ConnectionDataBase;
import mvc.database.DatabaseManager;
import mvc.intarfaces.Connectable;
import mvc.intarfaces.Modelable;

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
    public void createUser(String name, String login, String password, String email) {
        databaseManager.addUser(name, login, password, email);
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
