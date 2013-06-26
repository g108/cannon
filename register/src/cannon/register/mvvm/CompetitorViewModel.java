package cannon.register.mvvm;

import cannon.register.model.Competitor;
import cannon.register.service.CompetitorService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/13/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompetitorViewModel {

    private Competitor selectedCompetitor;
    private List<String> beltRanks = new ArrayList<String>(CompetitorService.getBeltRanks());
    private List<Competitor> competitors = new ArrayList<Competitor>(CompetitorService.getAllCompetitors());

    Competitor newCompetitor;
    private boolean stateAddCompetitor;

    @Init
    public void init() {
        reloadCompetitor();
    }

    public Competitor getSelectedCompetitor() {
        return selectedCompetitor;
    }

    public void setSelectedCompetitor(Competitor selectedCompetitor) {
        this.selectedCompetitor = selectedCompetitor;
    }

    @Command
    @NotifyChange({"stateAddCompetitor", "competitors", "selectedCompetitor"})
    public void addCompetitorForm() {
        stateAddCompetitor = true;
        newCompetitor = new Competitor();
        competitors.add(newCompetitor);
        selectedCompetitor = newCompetitor;
    }

    @Command
    @NotifyChange({"stateAddCompetitor"})
    public void saveNewCompetitor() {
        stateAddCompetitor = false;
        newCompetitor = CompetitorService.createCompetitor(newCompetitor.getFirstName(), newCompetitor.getLastName(),
                newCompetitor.getDob(), newCompetitor.getBeltRank());
    }

    @Command
    @NotifyChange({"competitors", "selectedCompetitor"})
    public void deleteCompetitor() {
        CompetitorService.deleteCompetitor(selectedCompetitor);
        reloadCompetitor();
    }

    @Command
    @NotifyChange({"stateAddCompetitor", "competitors", "selectedCompetitor"})
    public void reloadCompetitor() {
        stateAddCompetitor = false;
        competitors = CompetitorService.getAllCompetitors();
        selectedCompetitor = competitors.get(0);
    }

    public List<String> getBeltRanks() {
        return beltRanks;
    }

    public void setBeltRanks(List<String> beltRanks) {
        this.beltRanks = beltRanks;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public boolean isStateAddCompetitor() {
        return stateAddCompetitor;
    }

    public void setStateAddCompetitor(boolean stateAddCompetitor) {
        this.stateAddCompetitor = stateAddCompetitor;
    }
}
