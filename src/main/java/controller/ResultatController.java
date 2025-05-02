package controller;

import dao.CompetitionDao;
import dao.ParticipantDao;
import dao2.ResultatDao;
import org.entities.Competition;
import org.entities.Participant;
import org.entities.Resultat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/resultats")
public class ResultatController extends HttpServlet {
    private ResultatDao resultatDao;

    @Override
    public void init() {
        resultatDao = new ResultatDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        List<Resultat> resultats = resultatDao.findAll();

        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < resultats.size(); i++) {
            Resultat r = resultats.get(i);
            json.append("{")
                    .append("\"competitionId\":").append(r.getCompetition().getId()).append(",")
                    .append("\"participantId\":").append(r.getParticipant().getId()).append(",")
                    .append("\"score\":").append(r.getScore())
                    .append("}");
            if (i < resultats.size() - 1) json.append(",");
        }
        json.append("]");

        response.getWriter().write(json.toString());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String competitionNom = request.getParameter("competition_nom");
        String participantNom = request.getParameter("participant_nom");
        double score = Double.parseDouble(request.getParameter("score"));

        // Trouver les objets en base par nom
        Competition competition = new CompetitionDao().findByNom(competitionNom);
        Participant participant = new ParticipantDao().findByNom(participantNom);

        if (competition == null || participant == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nom invalide");
            return;
        }

        Resultat resultat = new Resultat();
        resultat.setCompetition(competition);
        resultat.setParticipant(participant);
        resultat.setScore(score);

        resultatDao.create(resultat);

        response.setStatus(HttpServletResponse.SC_OK);
    }

}
