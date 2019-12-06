package mvc.intarfaces;

import java.sql.Connection;

public interface Connectable {

    Connection getConnection();
}
