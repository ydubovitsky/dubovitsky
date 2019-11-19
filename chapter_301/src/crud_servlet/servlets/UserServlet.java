package crud_servlet.servlets;

import crud_servlet.ModelImpl;
import crud_servlet.beans.User;
import crud_servlet.intarfaces.Modelable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    /**
     * Model
     */
    private Modelable model;

    /**
     * Constructor
     * @param model
     */
    public UserServlet() {
        this.model = new ModelImpl();
    }

    /**
     * Этот метод получает всех пользователей из модели, перебирает их, сетает их как атрибуты с видимостью на уровне
     * приложения и форвардит это все на VIEW.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = model.getUsers();
        ServletContext servletContext = req.getServletContext();
        for (User user : users) {
            //TODO Можно ли запихнуть в атрибут объект? Наверное нет...
            // Запихни это все в контекст!
            servletContext.setAttribute(user.getName(), user);
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/jsp/crud_servlet/view.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
