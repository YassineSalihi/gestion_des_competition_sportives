package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;

        boolean isPublic = uri.endsWith("login.jsp") || uri.endsWith("register.jsp")
                || uri.endsWith("login") || uri.endsWith("register")
                || uri.contains("css") || uri.contains("js") || uri.contains("images");

        if (!loggedIn && !isPublic) {
            res.sendRedirect("login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
