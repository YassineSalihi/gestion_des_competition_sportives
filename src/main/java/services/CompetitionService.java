package services;

import dao2.CompetitionDao;
import org.entities.Competition;

import java.util.List;

public class CompetitionService {

    private CompetitionDao dao = new CompetitionDao();


    public boolean create(Competition c) {
        try {
            dao.create(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean update(Competition c) {
        try {
            dao.update(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean delete(Competition c) {
        try {
            dao.delete(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Competition findById(int id) {
        return dao.findById(id);
    }


    public List<Competition> findAll() {
        return dao.findAll();
    }
}
