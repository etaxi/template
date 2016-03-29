package lv.javaguru.java2.MVC;


import javax.servlet.http.HttpServletRequest;

public class HelloWorldController implements MVCController {


    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel("/hello.jsp", "Hello MVC");
    }
}
