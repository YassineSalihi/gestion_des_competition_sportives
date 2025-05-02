package controller;

import dao2.CompetitionDao;
import org.entities.Competition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/competitions")
public class CompetitionController extends HttpServlet {
    private CompetitionDao competitionDao;

    @Override
    public void init() {
        competitionDao = new CompetitionDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Competition> competitions = competitionDao.findAll();
        request.setAttribute("competitions", competitions);
        request.getRequestDispatcher("views/listeComp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String type = request.getParameter("type");
        String dateDebut = request.getParameter("dateDebut");
        String dateFin = request.getParameter("dateFin");

        Competition comp = new Competition(nom, type, dateDebut, dateFin);
        competitionDao.save(comp);
        response.sendRedirect("competitions");
    }
}
