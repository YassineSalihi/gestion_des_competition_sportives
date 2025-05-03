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

        String action = request.getParameter("action");
        ResultatDao resultatDao = new ResultatDao();
        CompetitionDao competitionDao = new CompetitionDao();
        ParticipantDao participantDao = new ParticipantDao();

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Resultat r = resultatDao.findById(id);
            if (r != null) resultatDao.delete(r);
            response.sendRedirect("resultats");
            return;
        }

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Resultat r = resultatDao.findById(id);
            request.setAttribute("editResultat", r);
        }

        // Charger les listes
        List<Competition> competitions = competitionDao.findAll();
        List<Participant> participants = participantDao.findAll();
        List<Resultat> resultats = resultatDao.findAll();

        request.setAttribute("competitions", competitions);
        request.setAttribute("participants", participants);
        request.setAttribute("resultats", resultats);

        request.getRequestDispatcher("views/resultats.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String competitionNom = request.getParameter("competition_nom");
        String participantNom = request.getParameter("participant_nom");
        double score = Double.parseDouble(request.getParameter("score"));

        Competition competition = new CompetitionDao().findByNom(competitionNom);
        Participant participant = new ParticipantDao().findByNom(participantNom);

        if (competition == null || participant == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nom invalide");
            return;
        }

        Resultat resultat = (idStr != null && !idStr.isEmpty())
                ? resultatDao.findById(Integer.parseInt(idStr))
                : new Resultat();

        resultat.setCompetition(competition);
        resultat.setParticipant(participant);
        resultat.setScore(score);

        if (idStr != null && !idStr.isEmpty()) {
            resultatDao.update(resultat);
        } else {
            resultatDao.create(resultat);
        }

        response.sendRedirect("resultats");
    }
}
