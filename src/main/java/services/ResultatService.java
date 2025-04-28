package services;

import dao2.ResultatDao;
import org.entities.Resultat;

import java.util.List;

public class ResultatService {

    private ResultatDao dao = new ResultatDao();

    public void create(Resultat r) {
        dao.create(r);
    }

    public void update(Resultat r) {
        dao.update(r);
    }

    public void delete(Resultat r) {
        dao.delete(r);
    }

    public Resultat findById(int id) {
        return dao.findById(id);
    }

    public List<Resultat> findAll() {
        return dao.findAll();
    }
}
