<%@ page import="crud_servlet.beans.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
    <%!
        /**
         * This method return all users on the user_s display.
         * @param user
         */
        private void outputUsers(User user, HttpServletResponse re) {
            try {
                PrintWriter writer = re.getWriter();
                writer.write(
                        "<h1>" + user.getName() + " " + user.getId() + "</h1>" +
                        "<br>" + user.getEmail() + user.getLogin() + user.getPassword()
                );
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    %>
    <%
        /**
         * This piece of code gets all request param, filters and output all object(Users)
         */
        ServletContext servletContext = request.getServletContext();
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            // Проверка на тип возвращаемого объекта по Имени
            if (servletContext.getAttribute(name) instanceof User) {
                outputUsers((User)servletContext.getAttribute(name), response);
            }
        }
    %>
</body>
</html>
