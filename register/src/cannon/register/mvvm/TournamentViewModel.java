package cannon.register.mvvm;

import cannon.register.model.Tournament;
import cannon.register.service.TournamentService;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/25/13
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class TournamentViewModel {

    private Tournament selectedTournament;
    private List<Tournament> tournaments = new ArrayList<Tournament>(TournamentService.getAllTournaments());

    Tournament newTournament;
    private boolean stateAddTournament;

    @Init
    public void init() {
        reloadTournament();
    }

    public Tournament getSelectedTournament() {
        return selectedTournament;
    }

    public void setSelectedTournament(Tournament selectedTournament) {
        this.selectedTournament = selectedTournament;
    }

    @Command
    @NotifyChange({"stateAddTournament", "tournaments", "selectedTournament"})
    public void addTournamentForm() {
        stateAddTournament = true;
        newTournament = new Tournament();
        tournaments.add(newTournament);
        selectedTournament = newTournament;
    }

    @Command
    @NotifyChange({"stateAddTournament"})
    public void saveNewTournament() {
        stateAddTournament = false;
        newTournament = TournamentService.createTournament(newTournament.getName(), newTournament.getVenue(),
                newTournament.getStartDate(), newTournament.getEndDate());
    }

    @Command
    @NotifyChange({"tournaments", "selectedTournament"})
    public void deleteTournament() {
        TournamentService.deleteTournament(selectedTournament);
        reloadTournament();
    }

    @Command
    @NotifyChange({"stateAddTournament", "tournaments", "selectedTournaments"})
    public void reloadTournament() {
        stateAddTournament = false;
        tournaments = TournamentService.getAllTournaments();
        selectedTournament = tournaments.get(0);
    }

    @Command
    public void testStripePayment() {
        Stripe.apiKey = "sk_test_MwfQwBxgqQlYyghLuu78JnUj";

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", 400);
        chargeParams.put("currency", "usd");
        chargeParams.put("card", "tok_25b7OfrP89cMio"); // obtained with Stripe.js
        chargeParams.put("description", "Charge for test@example.com");
        try {
            Charge.create(chargeParams);
            System.out.println("Charge Successful!!!");
        } catch (CardException e) {
            // Since it's a decline, CardException will be caught
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getParam());
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
            System.out.println("Invalid parameters: " + e);
        } catch (AuthenticationException e) {
            // Authentication with Stripe's API failed
            // (maybe you changed API keys recently)
            System.out.println("Authentication exception: " + e);
        } catch (APIConnectionException e) {
            // Network communication with Stripe failed
        } catch (StripeException e) {
            // Display a very generic error to the user, and maybe send
            // yourself an email
            System.out.println("Stripe exception: " + e);
        } catch (Exception e) {
            // Something else happened, completely unrelated to Stripe
            System.out.println("Unknown exception: " + e);
        }
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public boolean isStateAddTournament() {
        return stateAddTournament;
    }

    public void setStateAddTournament(boolean stateAddTournament) {
        this.stateAddTournament = stateAddTournament;
    }
}
