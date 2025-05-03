package dao;

import org.entities.Participant;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class ParticipantDao extends AbstractDao<Participant> {

    public ParticipantDao() {
        super(Participant.class);
    }

    public List<Participant> findByCategorie(String categorie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Participant p WHERE p.categorie = :cat", Participant.class)
                    .setParameter("cat", categorie)
                    .list();
        }
    }

    public Participant findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Participant.class, id);
        }
    }

    public Participant findByNom(String nom) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Participant p WHERE p.nom = :nom", Participant.class)
                    .setParameter("nom", nom)
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }

}

