package lv.javaguru.java2.servlet;

    import lv.javaguru.java2.database.jdbc.MySQLtest;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;

    /**
     * Created by Aleks on 22.03.2016.
     */
    public class MySQLServlet extends HttpServlet {

         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
       }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           request.setAttribute("users", MySQLtest.getCustomersListToList() );
           request.setAttribute("table", MySQLtest.getCustomersListToString() );
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //request.setAttribute("users", MySQLtest.getCustomersListToString());
           request.getRequestDispatcher("/mysqlpage.ftl").forward(request, response);

        }
    }

