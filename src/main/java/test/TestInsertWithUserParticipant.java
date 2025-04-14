package test;

import dao.ParticipantDao;
import dao.UserDao;
import org.entities.Participant;
import org.entities.User;

public class TestInsertWithUserParticipant {

    public static void main(String[] args) {
        // DAO
        UserDao userDao = new UserDao();
        ParticipantDao participantDao = new ParticipantDao();

        // 1. Créer un utilisateur
        User user = new User();
        user.setNom("Ait");
        user.setPrenom("Ichou");
        user.setEmail("ichou@uca.ma");
        user.setMotDePasse("pass123");  // mot de passe simple (non hashé ici)
        userDao.create(user);
        System.out.println("✅ Utilisateur inséré : " + user.getEmail());

        // 2. Créer un participant lié à cet utilisateur
        Participant participant = new Participant();
        participant.setNom("Ichou Rafik");
        participant.setCategorie("Elite");
        participant.setUser(user);  // 🔗 liaison ici
        participantDao.create(participant);
        System.out.println("✅ Participant inséré pour l'utilisateur : " + user.getEmail());

        // 3. Vérifier
        System.out.println("\n📋 Participants :");
        participantDao.findAll().forEach(p ->
                System.out.println("- " + p.getNom() + " (" + p.getCategorie() + ") ➤ Utilisateur : " )/*+ p.getUser().getEmail()*/
        );
    }
}
