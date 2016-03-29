package lv.javaguru.java2.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aleks on 29.03.2016.
 */
public interface MVCController {

    MVCModel processRequest(HttpServletRequest req );
}
