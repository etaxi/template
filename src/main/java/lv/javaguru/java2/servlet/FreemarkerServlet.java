package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleks on 22.03.2016.
 *
 * http://viralpatel.net/blogs/freemarker-servlet-tutorial-example/
 */
public class FreemarkerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static List<User> userList = new ArrayList<User>();

    //Just prepare static data to display on screen
    static {
        userList.add(new User(1, "Bill", "Gates"));
        userList.add(new User(2, "Steve", "Jobs"));
        userList.add(new User(3, "Larry", "Page"));
        userList.add(new User(4, "Sergey", "Brin"));
        userList.add(new User(5, "Larry", "Ellison"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        if(null != firstname && null != lastname
                && !firstname.isEmpty() && !lastname.isEmpty()) {

            synchronized (userList) {
                userList.add(new User(firstname, lastname));
            }
        }
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Put the user list in request and
        //let freemarker paint it.
        request.setAttribute("users", userList);

        request.getRequestDispatcher("/freemarker.ftl").forward(request, response);

    }
}
