package cannon.register.mvvm;

import cannon.register.model.Tournament;
import cannon.register.service.TournamentService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import java.util.ArrayList;
import java.util.List;

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
