package dao2;

import org.entities.Participant;
import org.hibernate.Session;
import util.HibernateUtil;

public class ParticipantDao extends AbstractDao<Participant> {
    public ParticipantDao() {
        super(Participant.class);
    }

    public Participant findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Participant.class, id);
        }
    }

    public Participant findByNom(String nom) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Participant WHERE nom = :nom", Participant.class)
                    .setParameter("nom", nom)
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }
}
