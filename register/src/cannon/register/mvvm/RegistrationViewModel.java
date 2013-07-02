package cannon.register.mvvm;

import cannon.register.model.*;
import cannon.register.service.CompetitorService;
import cannon.register.service.TournamentService;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Sessions;

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
public class RegistrationViewModel {

    private Tournament selectedTournament;
    private List<Tournament> tournaments = new ArrayList<Tournament>(TournamentService.getAllTournaments());

    private List<Competitor> myCompetitors =
            new ArrayList<Competitor>(CompetitorService.getCompetitorsForUser(
                    ((User) Sessions.getCurrent().getAttribute("user")).getEmail()));
    private List<Competitor> registeredCompetitors = new ArrayList<Competitor>();
    private Competitor selectedCompetitor;

    private CardInfo cardInfo;
    private ChargeInfo chargeInfo;
    private boolean stateRegistering;
    private boolean statePaying;

    @Init
    public void init() {
        reloadTournament();
        cardInfo = new CardInfo();
        cardInfo.setExpirationMonth(12);
        cardInfo.setExpirationYear(2015);
        chargeInfo = new ChargeInfo();
        chargeInfo.setCurrency("usd");
    }

    public Tournament getSelectedTournament() {
        return selectedTournament;
    }

    public void setSelectedTournament(Tournament selectedTournament) {
        this.selectedTournament = selectedTournament;
    }

    @Command
    @NotifyChange({"stateRegistering", "statePaying", "tournaments", "selectedTournaments"})
    public void reloadTournament() {
        stateRegistering = false;
        statePaying = false;
        tournaments = TournamentService.getAllTournaments();
        selectedTournament = tournaments.get(0);
    }

    @Command
    @NotifyChange({"stateRegistering"})
    public void startRegistration() {
        stateRegistering = true;
    }

    @Command
    @NotifyChange("stateRegistering")
    public void cancelRegistration() {
        stateRegistering = false;
    }

    @Command
    @NotifyChange({"statePaying"})
    public void startPayment() {
        Stripe.apiKey = "sk_test_MwfQwBxgqQlYyghLuu78JnUj";
        statePaying = true;
    }

    @Command
    @NotifyChange("statePaying")
    public void makePayment() {
        Map<String, Object> cardParams = new HashMap<String, Object>();
        cardParams.put("number", cardInfo.getCardNumber());
        cardParams.put("exp_month", cardInfo.getExpirationMonth());
        cardParams.put("exp_year", cardInfo.getExpirationYear());

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", chargeInfo.getAmount());
        chargeParams.put("currency", chargeInfo.getCurrency());
        chargeParams.put("description", "Charges for " + selectedTournament.getName());
        chargeParams.put("card", cardParams);

        try {
            Charge.create(chargeParams);
            System.out.println("Charge Successful!!!");
            statePaying = false;
        } catch (CardException e) {
            // Since it's a decline, CardException will be caught
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getMessage());
            System.out.println("Param is: " + e.getParam());
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

    @Command
    @NotifyChange("statePaying")
    public void cancelPayment() {
        statePaying = false;
    }

    public String getDivisionsForCompetitor(Competitor competitor) {
        return "";
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public List<Competitor> getMyCompetitors() {
        return myCompetitors;
    }

    public void setMyCompetitors(List<Competitor> myCompetitors) {
        this.myCompetitors = myCompetitors;
    }

    public List<Competitor> getRegisteredCompetitors() {
        return registeredCompetitors;
    }

    public void setRegisteredCompetitors(List<Competitor> registeredCompetitors) {
        this.registeredCompetitors = registeredCompetitors;
    }

    public Competitor getSelectedCompetitor() {
        return selectedCompetitor;
    }

    public void setSelectedCompetitor(Competitor selectedCompetitor) {
        this.selectedCompetitor = selectedCompetitor;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public ChargeInfo getChargeInfo() {
        return chargeInfo;
    }

    public void setChargeInfo(ChargeInfo chargeInfo) {
        this.chargeInfo = chargeInfo;
    }

    public boolean isStateRegistering() {
        return stateRegistering;
    }

    public void setStateRegistering(boolean stateRegistering) {
        this.stateRegistering = stateRegistering;
    }

    public boolean isStatePaying() {
        return statePaying;
    }

    public void setStatePaying(boolean statePaying) {
        this.statePaying = statePaying;
    }
}
