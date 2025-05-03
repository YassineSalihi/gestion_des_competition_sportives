package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        boolean publicPage = uri.endsWith("login.jsp") || uri.endsWith("register.jsp") ||
                uri.contains("/login") || uri.contains("/register") ||
                uri.contains("/logout") ||
                uri.contains(".css") || uri.contains(".js") ||
                uri.contains(".png") || uri.contains(".jpg") || uri.contains(".jpeg");

        if (loggedIn || publicPage) {
            // ✅ Empêcher le retour en arrière après déconnexion
            res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            res.setHeader("Pragma", "no-cache");
            res.setDateHeader("Expires", 0);

            chain.doFilter(request, response);
        } else {
            // ✅ Redirection vers la page de connexion
            res.sendRedirect("login.jsp");
        }
    }
}
