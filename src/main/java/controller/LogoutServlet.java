package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // ne pas créer de session si elle n’existe pas
        if (session != null) {
            session.invalidate(); // Supprimer la session
        }

        // Empêcher le retour en arrière après déconnexion
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        // Rediriger vers la page de connexion
        response.sendRedirect("login.jsp");
    }
}
