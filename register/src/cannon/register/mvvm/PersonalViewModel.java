package cannon.register.mvvm;

import cannon.register.model.User;
import cannon.register.service.UserService;
import org.zkoss.bind.annotation.Init;


/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/19/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonalViewModel {
    private User user;

    @Init
    public void init() {
        user = UserService.login("lnac98@gmail.com");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
