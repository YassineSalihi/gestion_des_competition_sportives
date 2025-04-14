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
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        CompetitionDao competitionDao = new CompetitionDao();
        ParticipantDao participantDao = new ParticipantDao();
        ResultatDao resultatDao = new ResultatDao();

        // 🔎 Filtrer les compétitions par type
        System.out.println("\n🎯 Compétitions de type 'Athlétisme' :");
        List<Competition> atletismeComps = competitionDao.findByType("Athlétisme");
        atletismeComps.forEach(c ->
                System.out.println("- " + c.getNom() + " (" + c.getDateDebut() + ")")
        );

        // 🔎 Filtrer les compétitions entre deux dates
        Date debut = new Date(System.currentTimeMillis() - (10L * 24 * 60 * 60 * 1000)); // 10 jours avant
        Date fin = new Date();
        System.out.println("\n📅 Compétitions entre " + debut + " et " + fin + " :");
        List<Competition> activeComps = competitionDao.findActiveBetween(debut, fin);
        activeComps.forEach(c ->
                System.out.println("- " + c.getNom() + " (" + c.getDateDebut() + " - " + c.getDateFin() + ")")
        );

        // 🔎 Afficher les résultats d'un participant
        System.out.println("\n📊 Résultats de 'Ait Hmad' :");
        List<Participant> participants = participantDao.findAll();
        Participant p = participants.stream()
                .filter(part -> part.getNom().equals("Ait Hmad"))
                .findFirst().orElse(null);

        if (p != null) {
            List<Resultat> resultats = resultatDao.findAll();
            resultats.stream()
                    .filter(r -> r.getParticipant().getId() == p.getId())
                    .forEach(r -> System.out.println(r.getCompetition().getNom() + " ➤ Score: " + r.getScore()));
        } else {
            System.out.println("Aucun participant nommé 'Ait Hmad' trouvé.");
        }
        /*User user0 = new User();
        user0.setNom("Ben Salah");
        user0.setPrenom("Youssef");
        user0.setEmail("youssef.bs@uca.ma");
        user0.setMotDePasse("pass123");
        userDao.create(user0);
        System.out.println("✅ Utilisateur Youssef inséré.");

        User user1 = new User();
        user1.setNom("Najib");
        user1.setPrenom("Oussama");
        user1.setEmail("ous.najib@uca.ac.ma");
        user1.setMotDePasse("123456");
        userDao.create(user1);
        System.out.println("✅ Utilisateur Oussama inséré.");

        Competition comp0 = new Competition();
        comp0.setNom("Tournoi National");
        comp0.setType("Football");
        comp0.setDateDebut(new Date());
        comp0.setDateFin(new Date());
        competitionDao.create(comp0);
        System.out.println("✅ Compétition Tournoi National insérée.");

        Competition comp1 = new Competition();
        comp1.setNom("Défi Printemps");
        comp1.setType("Cyclisme");
        comp1.setDateDebut(new Date());
        comp1.setDateFin(new Date());
        competitionDao.create(comp1);
        System.out.println("✅ Compétition Défi Printemps insérée.");

        Participant part0 = new Participant();
        part0.setNom("Mehdi");
        part0.setCategorie("Sénior");
        participantDao.create(part0);
        System.out.println("✅ Participant Mehdi inséré.");

        Participant part1 = new Participant();
        part1.setNom("Karim");
        part1.setCategorie("Junior");
        participantDao.create(part1);
        System.out.println("✅ Participant Karim inséré.");

        Resultat r0 = new Resultat();
        r0.setCompetition(comp1);
        r0.setParticipant(part0);
        r0.setScore(70.72);
        resultatDao.create(r0);
        System.out.println("✅ Résultat 1 inséré.");

        Resultat r1 = new Resultat();
        r1.setCompetition(comp0);
        r1.setParticipant(part1);
        r1.setScore(76.29);
        resultatDao.create(r1);
        System.out.println("✅ Résultat 2 inséré.");*/
    }
}

