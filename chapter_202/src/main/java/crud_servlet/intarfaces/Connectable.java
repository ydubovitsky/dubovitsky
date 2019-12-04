package crud_servlet.intarfaces;

import java.sql.Connection;

public interface Connectable {

    Connection getConnection();
}
