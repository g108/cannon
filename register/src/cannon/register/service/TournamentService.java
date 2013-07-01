package cannon.register.service;

import cannon.register.model.Tournament;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/25/13
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class TournamentService {

    private static List<Tournament> tournaments = new ArrayList<Tournament>();

    static {
        tournaments.add(new Tournament("War at the Warehouse", "Sanford Airport", "/images/logos/war.jpg"));
        tournaments.add(new Tournament("Fighting Lion", "Central Florida Chrysler Jeep Dodge", "/images/logos/lion.jpg"));
        tournaments.add(new Tournament("US Breaking Championships", "Central Florida Chrysler Jeep Dodge"));
        tournaments.add(new Tournament("Terracotta Challenge", "Northland Church"));
    }

    public static Tournament createTournament(String title, String venue, Date startDate, Date endDate) {
        Tournament tournament = new Tournament(title, venue);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        tournaments.add(tournament);
        return tournament;

    }

    public static List<Tournament> getAllTournaments() {
        return new ArrayList<Tournament>(tournaments);
    }

    public static void deleteTournament(Tournament tournament) {
        tournaments.remove(tournament);
    }
}
