package cannon.register.service;

import cannon.register.model.Competitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/13/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompetitorService {

    private static List<String> beltRanks = new ArrayList<String>();
    private static List<Competitor> competitors = new ArrayList<Competitor>();

    static {
        beltRanks.add("Novice");
        beltRanks.add("Beginner");
        beltRanks.add("Intermediate");
        beltRanks.add("Advanced");
        beltRanks.add("Black Belt - 17 & under");
        beltRanks.add("Black Belt - adult");

        competitors.add(new Competitor("Hannah", "Cash", new Date(), "Beginner"));
        competitors.add(new Competitor("Elizabeth", "Cash", new Date(), "Beginner"));
        competitors.add(new Competitor("Rachel", "Cash", new Date(), "Novice"));
    }

    public static Competitor createCompetitor(String firstName, String lastName, Date dob, String beltRank) {
        Competitor competitor = new Competitor(firstName, lastName, dob, beltRank);
        competitors.add(competitor);
        return competitor;

    }

    public static List<String> getBeltRanks() {
        return beltRanks;
    }

    public static List<Competitor> getAllCompetitors() {
        return new ArrayList<Competitor>(competitors);
    }

    public static void deleteCompetitor(Competitor competitor) {
        competitors.remove(competitor);
    }

}
