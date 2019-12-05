package crud_servlet.layouts;

import java.util.List;

public interface Logic {

    void add(String name);
    void update(int id, String name);
    void delete(int id);
    List displayRecords();
}
