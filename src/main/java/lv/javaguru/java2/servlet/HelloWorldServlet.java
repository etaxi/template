package lv.javaguru.java2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:viktor.savonin@odnoklassniki.ru">Viktor Savonin</a>
 */
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
	                     HttpServletResponse resp) throws ServletException, IOException {

		// Set response content type
		resp.setContentType("text/html");

		// Prepare output html
		PrintWriter out = resp.getWriter();
		out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");		
		out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
		out.println("<a href='http://localhost:8080/hello'>  /hello  </a> <br>");
		out.println("<a href='http://localhost:8080/paramProcessing?param1=23'>paramPrecessing</a> <br>");
		out.println("<a href='http://localhost:8080/session'>  /session  </a> <br>");
		out.println("<a href='http://localhost:8080/jsp'>  /jsp  </a>");
	}

}
