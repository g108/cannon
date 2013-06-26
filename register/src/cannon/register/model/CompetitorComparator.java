package cannon.register.model;

import cannon.register.model.Competitor;
import org.zkoss.zul.GroupComparator;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/13/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompetitorComparator implements Comparator<Competitor>, GroupComparator<Competitor>, Serializable {
    private static final long serialVersionUID = 1L;

    public int compare(Competitor o1, Competitor o2) {
        return o1.getBeltRank().compareTo(o2.getBeltRank().toString());
    }

    public int compareGroup(Competitor o1, Competitor o2) {
        if(o1.getBeltRank().equals(o2.getBeltRank()))
            return 0;
        else
            return 1;
    }
}
