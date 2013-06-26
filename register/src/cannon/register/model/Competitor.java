package cannon.register.model;

import org.zkoss.bind.annotation.DependsOn;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/13/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Competitor {
    private String firstName;
    private String lastName;
    private Date dob;
    private String beltRank;

    public Competitor() {
        new Competitor("", "", new Date(), "Novice");
    }

    public Competitor(String firstName, String lastName, Date dob, String beltRank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.beltRank = beltRank;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBeltRank() {
        return beltRank;
    }

    public void setBeltRank(String beltRank) {
        this.beltRank = beltRank;
    }

    @DependsOn({ "firstName", "lastName" })
    public String getFullName() {
        String fName = getFirstName() == null ? "" : getFirstName();
        String lName = getLastName() == null ? "" : getLastName();
        return fName + " " + lName;
    }
}
