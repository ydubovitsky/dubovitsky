package crud_servlet.layouts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Presentation {

    void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
