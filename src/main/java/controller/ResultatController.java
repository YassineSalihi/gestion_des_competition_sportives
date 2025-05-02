package controller;

import dao2.ResultatDao;
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
        List<Resultat> resultats = resultatDao.findAll();
        request.setAttribute("resultats", resultats);
        request.getRequestDispatcher("views/resultats.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int competitionId = Integer.parseInt(request.getParameter("competition_id"));
        int participantId = Integer.parseInt(request.getParameter("participant_id"));
        double score = Double.parseDouble(request.getParameter("score"));

        Resultat resultat = new Resultat(competitionId, participantId, score);
        resultatDao.save(resultat);
        response.sendRedirect("resultats");
    }
}
