package lv.javaguru.java2.MVC;

import lv.javaguru.java2.config.SpringConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;



public class MVCFilter implements Filter {
    private Map<String, MVCController> urlToControllerMap;
    private ApplicationContext springContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


     springContext = new AnnotationConfigApplicationContext(SpringConfig.class);


        urlToControllerMap = new HashMap<>();
        urlToControllerMap.put("/hello", getBean(HelloWorldController.class));
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

    private MVCController getBean(Class clazz)
    {
        return (MVCController) springContext.getBean(clazz);
    }
}
