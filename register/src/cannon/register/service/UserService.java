package cannon.register.service;

import cannon.register.model.User;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/20/13
 * Time: 8:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserService {
    private static Map<String, User> users = new HashMap<String, User>();

    static {
        users.put("lnac98@gmail.com", new User("Lance", "Cash", new Date(), "lnac98@gmail.com", "595 Clemson Dr", "", "Altamonte Springs", "FL", "32714", true));
        users.put("skipper.jason@gmail.com", new User("Jason", "Skipper", new Date(), "skipper.jason@gmail.com", "111 Silver Springs Dr", "", "Sanford", "FL", "32777", false));
    }

    public static User login(String email) {
        User currentUser = users.get(email);
        Session session = Sessions.getCurrent();
        session.setAttribute("user", currentUser);
        return currentUser;
    }
}
