package dao2;

import org.entities.Competition;

public class CompetitionDao extends AbstractDao<Competition> {
    public CompetitionDao() {
        super(Competition.class);
    }

    public Competition findById(int id) {
        return super.findById(id);
    }
}
