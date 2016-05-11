package lv.javaguru.java2.Authorization.tests;


import junit.framework.TestCase
import lv.javaguru.java2.Authorization.db.Database
import lv.javaguru.java2.Authorization.services.AuthorizationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AuthorizationServiceTest extends TestCase {

    Database db = new Database();
    AuthorizationService authorizationService = new AuthorizationService(db);

    @Before
    public void before(){
        db = new Database();
        authorizationService = new AuthorizationService(db);
    }

    @After
    public void after(){
        System.out.print(db.toString());
    }

    @Test
    public void testAuthorizationIncorrecy() throws Exception {

        boolean verification = authorizationService.authorization("user", "pas");
        assertEquals(verification, false);
    }

    @Test
    public void testAuthorizationCorrect() throws Exception {

        boolean verification = authorizationService.authorization("user1", "password1");
        assertEquals(verification, true);
    }

    @Test
    public void testAuthorizationLoginIsEmpty() throws Exception {

        boolean verification = authorizationService.authorization("", "password1");
        assertEquals(verification, false);
    }

    @Test
    public void testAuthorizationPasswordIsEmpty() throws Exception {

        boolean verification = authorizationService.authorization("user1", "");
        assertEquals(verification, false);
    }

    @Test
    public void testAuthorizationLoginNotExist() throws Exception {

        boolean verification = authorizationService.authorization("admin", "password");
        assertEquals(verification, false);
    }

    @Test
    public void testAuthorizationLoginIsBlocked() throws Exception {

        boolean verification = authorizationService.authorization("user2", "password2");
        assertEquals(verification, false);
    }

}