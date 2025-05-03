package controller;

import dao.ParticipantDao;
import org.entities.Participant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/participants")
public class ParticipantController extends HttpServlet {
    private ParticipantDao participantDao;

    @Override
    public void init() {
        participantDao = new ParticipantDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Participant p = participantDao.findById(id);
            request.setAttribute("participant", p);
            request.getRequestDispatcher("views/editParticipant.jsp").forward(request, response);
        } else {
            List<Participant> participants = participantDao.findAll();
            request.setAttribute("participants", participants);
            request.getRequestDispatcher("views/participants.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String nom = request.getParameter("nom");
            String categorie = request.getParameter("categorie");
            Participant p = new Participant();
            p.setNom(nom);
            p.setCategorie(categorie);
            participantDao.create(p);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String categorie = request.getParameter("categorie");
            Participant p = participantDao.findById(id);
            p.setNom(nom);
            p.setCategorie(categorie);
            participantDao.update(p);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Participant p = participantDao.findById(id);
            participantDao.delete(p);
        }

        response.sendRedirect("participants");
    }
}
