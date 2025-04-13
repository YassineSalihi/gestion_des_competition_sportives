package dao;

import org.entities.Competition;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class CompetitionDao extends AbstractDao<Competition> {

    public CompetitionDao() {
        super(Competition.class);
    }

    public List<Competition> findByType(String type) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Competition c WHERE c.type = :type", Competition.class)
                    .setParameter("type", type)
                    .list();
        }
    }

    public List<Competition> findActiveBetween(Date debut, Date fin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM Competition c WHERE c.dateDebut >= :debut AND c.dateFin <= :fin", Competition.class)
                    .setParameter("debut", debut)
                    .setParameter("fin", fin)
                    .list();
        }
    }
}
