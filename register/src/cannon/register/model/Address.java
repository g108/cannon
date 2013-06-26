package cannon.register.model;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/25/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Address {

    private String street;
    private String aptSuite;
    private String city;
    private String state;
    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAptSuite() {
        return aptSuite;
    }

    public void setAptSuite(String aptSuite) {
        this.aptSuite = aptSuite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
