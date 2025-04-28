package services;

import dao2.ParticipantDao;
import org.entities.Participant;

import java.util.List;

public class ParticipantService {

    private ParticipantDao dao = new ParticipantDao();

    public void create(Participant p) {
        dao.create(p);
    }

    public void update(Participant p) {
        dao.update(p);
    }

    public void delete(Participant p) {
        dao.delete(p);
    }

    public Participant findById(int id) {
        return dao.findById(id);
    }

    public List<Participant> findAll() {
        return dao.findAll();
    }
}
