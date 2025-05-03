package controller;

import dao2.UserDao;
import org.entities.User;
import util.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        User user = userDao.findByEmail(email);

        if (user != null) {
            String newPass = UUID.randomUUID().toString().substring(0, 8);
            user.setMotDePasse(newPass);
            userDao.update(user);

            try {
                EmailSender.sendEmail(email, "Réinitialisation du mot de passe",
                        "Bonjour, votre nouveau mot de passe est : " + newPass);
                request.setAttribute("success", "Un nouveau mot de passe a été envoyé à votre email.");
            } catch (Exception e) {
                request.setAttribute("error", "Erreur lors de l'envoi de l'email : " + e.getMessage());
            }

        } else {
            request.setAttribute("error", "Aucun utilisateur trouvé avec cet email.");
        }

        request.getRequestDispatcher("forgot.jsp").forward(request, response);
    }
}
