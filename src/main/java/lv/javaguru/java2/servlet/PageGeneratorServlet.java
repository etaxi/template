package lv.javaguru.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lv.javaguru.java2.database.jdbc.MySQLtest;
import lv.javaguru.java2.servlet.PageGenerator;

/**
 * Created by Aleks on 22.03.2016.
 */
@WebServlet(name = "PageGeneratorServlet", urlPatterns = {"/PageGeneratorTest"} )
public class PageGeneratorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, Object> pageVariables = new HashMap<>();
//        pageVariables.put("table", "123");
//
//        response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
//        response.setContentType("text/html;charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();

        pageVariables.put("table", MySQLtest.getCustomersListToString());

        PageGenerator pageGenerator = new PageGenerator();

        String page = pageGenerator.getPage("page.ftl", pageVariables);
        System.out.print(page);

        response.getWriter().println(page);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
