package crud_servlet;

import crud_servlet.entity.Users;
import crud_servlet.layouts.Logic;
import crud_servlet.layouts.Presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/presentation")
public class UsersServlet extends HttpServlet implements Presentation {

    private Logic logic;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        //TODO Нужна ли тут синхронизация? Мы ведь только читаем
        synchronized (this) {
            List<Users> list = logic.displayRecords();
            for (Users u : list) {
                writer.write(u.getName());
            }
            writer.flush();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO Применить паттер
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        synchronized (this) {
            if (action.equals("add")) {
                logic.add(name);
            }
            if (action.equals("delete")) {
                logic.delete(Integer.valueOf(id));
            }
            if (action.equals("update")) {
                logic.update(Integer .valueOf(id), name);
            }
        }
    }

    /**
     * //TODO Вызывается только один раз при создании сервлета, наверное можно обойтись и без синглетона.
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        logic = new ValidateService();
    }
}
