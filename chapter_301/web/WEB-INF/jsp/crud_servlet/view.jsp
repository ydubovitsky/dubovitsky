<%@ page import="java.util.Enumeration" %>
<%@ page import="crud_servlet.beans.User" %>
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
        private void outputUsers(User user) {
            System.out.println(
                    "<h1>" + user.getName() + " " + user.getId() + "</h1>" +
                    "<br>" + user.getEmail() + user.getLogin() + user.getPassword()
            );
        }
    %>
    <%
        /**
         * This piece of code gets all request param and output all object(Users)
         */
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            outputUsers((User)request.getAttribute(name));
        }
    %>
</body>
</html>
