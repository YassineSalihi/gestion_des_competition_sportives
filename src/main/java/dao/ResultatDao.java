package dao;

import org.entities.Resultat;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class ResultatDao extends AbstractDao<Resultat> {

    public ResultatDao() {
        super(Resultat.class);
    }

    public List<Resultat> findByCompetitionId(int competitionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Resultat r WHERE r.competition.id = :compId", Resultat.class)
                    .setParameter("compId", competitionId)
                    .list();
        }
    }

    public List<Resultat> findByParticipantId(int participantId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Resultat r WHERE r.participant.id = :partId", Resultat.class)
                    .setParameter("partId", participantId)
                    .list();
        }
    }
}
