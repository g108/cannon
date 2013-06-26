package cannon.register.service;

import cannon.register.model.User;

import java.util.*;


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
        users.put("Cash", new User("Lance", "Cash", new Date(), "595 Clemson Dr", "", "Altamonte Springs", "FL", "32714", true));
        users.put("Skipper", new User("Jason", "Skipper", new Date(), "111 Silver Springs Dr", "", "Sanford", "FL", "32777", false));
    }

    public static User getUser(String lastName) {
        return users.get(lastName);
    }
}
