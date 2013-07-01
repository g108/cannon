package cannon.register.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/25/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tournament {

    private String name;
    private String venue;
    private Address address;
    private Date startDate;
    private Date endDate;
    private double registrationFee;
    private String maSchool;
//    private List<TournamentOrganizer> tournamentOrganizers;
//    private List<Division> divisions;
    private String circuit;
    private String logoPath;

    public Tournament() {
        new Tournament("", "");
        startDate = new Date();
        endDate = new Date();
    }

    public Tournament(String name, String venue) {
        this.name = name;
        this.venue = venue;
    }

    public Tournament(String name, String venue, String logoPath) {
        this.name = name;
        this.venue = venue;
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public String getMaSchool() {
        return maSchool;
    }

    public void setMaSchool(String maSchool) {
        this.maSchool = maSchool;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
