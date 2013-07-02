package cannon.register.mvvm;

import cannon.register.model.Competitor;
import cannon.register.model.Tournament;
import cannon.register.service.TournamentService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.Image;
import org.zkoss.util.media.Media;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 7/2/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class TournamentViewModel {

    public static String IMAGE_PATH = "/data/devl/projects/cannon/register/web/images/logos/";
    public static String IMAGE_PATH_RELATIVE = "/images/logos/";

    private Tournament selectedTournament;
    private List<Tournament> tournaments = new ArrayList<Tournament>(TournamentService.getAllTournaments());

    private Competitor selectedCompetitor;
    private List<Competitor> registeredCompetitors = new ArrayList<Competitor>();

    private Tournament newTournament;
    private boolean stateAddTournament;

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
    @NotifyChange({"stateAddTournament", "stateRegistering", "statePaying", "tournaments", "selectedTournaments"})
    public void reloadTournament() {
        stateAddTournament = false;
        tournaments = TournamentService.getAllTournaments();
        selectedTournament = tournaments.get(0);
    }

    public Image saveLogo(Media media) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            InputStream fin = media.getStreamData();
            in = new BufferedInputStream(fin);

            File baseDir = new File(IMAGE_PATH);

            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            File file = new File(IMAGE_PATH + media.getName());

            OutputStream fout = new FileOutputStream(file);
            out = new BufferedOutputStream(fout);
            byte buffer[] = new byte[1024];
            int ch = in.read(buffer);
            while (ch != -1) {
                out.write(buffer, 0, ch);
                ch = in.read(buffer);
            }
            System.out.println("Successful upload :" + media.getName());
            selectedTournament.setLogoPath(IMAGE_PATH_RELATIVE + media.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (out != null)
                    out.close();

                if (in != null)
                    in.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return (Image) media;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Tournament getSelectedTournament() {
        return selectedTournament;
    }

    public void setSelectedTournament(Tournament selectedTournament) {
        this.selectedTournament = selectedTournament;
    }

    public boolean isStateAddTournament() {
        return stateAddTournament;
    }

    public void setStateAddTournament(boolean stateAddTournament) {
        this.stateAddTournament = stateAddTournament;
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




}
