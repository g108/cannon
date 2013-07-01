package cannon.register.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/19/13
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private String homeStreet;
    private String homeAptSuite;
    private String homeCity;
    private String homeState;
    private String homeZip;
    private boolean homeSameAsBilling;
    private String billingName;
    private String billingStreet;
    private String billingAptSuite;
    private String billingCity;
    private String billingState;
    private String billingZip;

    public User(String firstName, String lastName, Date dob, String email, String homeStreet, String homeAptSuite, String homeCity,
                String homeState, String homeZip, boolean homeSameAsBilling) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.homeStreet = homeStreet;
        this.homeAptSuite = homeAptSuite;
        this.homeCity = homeCity;
        this.homeState = homeState;
        this.homeZip = homeZip;
        this.homeSameAsBilling = homeSameAsBilling;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeStreet() {
        return homeStreet;
    }

    public void setHomeStreet(String homeStreet) {
        this.homeStreet = homeStreet;
    }

    public String getHomeAptSuite() {
        return homeAptSuite;
    }

    public void setHomeAptSuite(String homeAptSuite) {
        this.homeAptSuite = homeAptSuite;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public boolean isHomeSameAsBilling() {
        return homeSameAsBilling;
    }

    public void setHomeSameAsBilling(boolean homeSameAsBilling) {
        this.homeSameAsBilling = homeSameAsBilling;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingAptSuite() {
        return billingAptSuite;
    }

    public void setBillingAptSuite(String billingAptSuite) {
        this.billingAptSuite = billingAptSuite;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }
}
