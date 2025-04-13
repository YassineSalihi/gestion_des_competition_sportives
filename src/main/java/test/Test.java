package test;

import dao.CompetitionDao;
import dao.ParticipantDao;
import dao.ResultatDao;
import dao.UserDao;
import org.entities.Competition;
import org.entities.Participant;
import org.entities.Resultat;
import org.entities.User;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // --- Instancier les DAO ---
        UserDao userDao = new UserDao();
        CompetitionDao competitionDao = new CompetitionDao();
        ParticipantDao participantDao = new ParticipantDao();
        ResultatDao resultatDao = new ResultatDao();

        // --- Créer un utilisateur ---
        User user = new User();
        user.setNom("Salihi");
        user.setPrenom("Yassine");
        user.setEmail("yassine@example.com");
        user.setMotDePasse("1234"); // stocké tel quel (voir UserDao)
        userDao.create(user);
        System.out.println("✅ Utilisateur inséré.");

        // --- Créer une compétition ---
        Competition comp = new Competition();
        comp.setNom("Championnat Universitaire");
        comp.setType("Sport");
        comp.setDateDebut(new Date());
        comp.setDateFin(new Date());
        competitionDao.create(comp);
        System.out.println("✅ Compétition insérée.");

        // --- Créer un participant ---
        Participant p = new Participant();
        p.setNom("Rafik");
        p.setCategorie("Junior");
        participantDao.create(p);
        System.out.println("✅ Participant inséré.");

        // --- Créer un résultat ---
        Resultat r = new Resultat();
        r.setCompetition(comp);
        r.setParticipant(p);
        r.setScore(87.5);
        resultatDao.create(r);
        System.out.println("✅ Résultat inséré.");

        // --- Afficher tout ---
        System.out.println("\n📋 Liste des utilisateurs :");
        userDao.findAll().forEach(u ->
                System.out.println(u.getNom() + " " + u.getPrenom() + " (" + u.getEmail() + ")")
        );

        System.out.println("\n📋 Liste des compétitions :");
        competitionDao.findAll().forEach(c ->
                System.out.println(c.getNom() + " [" + c.getType() + "]")
        );

        System.out.println("\n📋 Liste des participants :");
        participantDao.findAll().forEach(part ->
                System.out.println(part.getNom() + " - " + part.getCategorie())
        );

        System.out.println("\n📋 Liste des résultats :");
        resultatDao.findAll().forEach(res ->
                System.out.println("🏅 " + res.getParticipant().getNom() +
                        " ➤ " + res.getCompetition().getNom() + " : " + res.getScore())
        );
    }
}

