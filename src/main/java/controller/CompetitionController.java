package controller;

import dao2.CompetitionDao;
import org.entities.Competition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
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

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Competition c = competitionDao.findById(id);
            competitionDao.delete(c);
            response.sendRedirect("competitions");

        } else if ("edit".equals(action)) {
            String idStr = request.getParameter("id");
            Competition c = null;

            // ✅ Si id est présent, on cherche une compétition à modifier
            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                c = competitionDao.findById(id);
            }

            // ✅ Sinon, on ouvre le formulaire vide (création)
            request.setAttribute("competition", c);
            request.getRequestDispatcher("views/editCompetition.jsp").forward(request, response);

        } else {
            List<Competition> competitions = competitionDao.findAll();
            request.setAttribute("competitions", competitions);
            request.getRequestDispatcher("views/listeComp.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nom = request.getParameter("nom");
        String type = request.getParameter("type");
        Date dateDebut = java.sql.Date.valueOf(request.getParameter("dateDebut"));
        Date dateFin = java.sql.Date.valueOf(request.getParameter("dateFin"));

        Competition c = new Competition();
        c.setNom(nom);
        c.setType(type);
        c.setDateDebut(dateDebut);
        c.setDateFin(dateFin);

        if (idStr != null && !idStr.isEmpty()) {
            c.setId(Integer.parseInt(idStr));
            competitionDao.update(c);
        } else {
            competitionDao.save(c);
        }

        response.sendRedirect("competitions");
    }
}

