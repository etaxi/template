package lv.javaguru.java2.MVC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Aleks on 29.03.2016.
 */
public class MVCFilter implements Filter {
    private Map<String, MVCController> urlToControllerMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urlToControllerMap = new HashMap<>();
        urlToControllerMap.put("/hello", new HelloWorldController());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String contextURL = req.getServletPath();

//        if (contextURL.equals("/index")) {
//            filterChain.doFilter();
//        } else {
//

        MVCController controller = urlToControllerMap.get(contextURL);
        MVCModel model = controller.processRequest(req);

        req.setAttribute("model", model.getData());

        ServletContext context = req.getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getJspName());
        requestDispatcher.forward(req, res);

    }

    @Override
    public void destroy() {

    }
}
