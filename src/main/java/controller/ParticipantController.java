package controller;

import dao2.ParticipantDao;
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
        List<Participant> participants = participantDao.findAll();
        request.setAttribute("participants", participants);
        request.getRequestDispatcher("views/participants.jsp").forward(request, response);
    }
}
