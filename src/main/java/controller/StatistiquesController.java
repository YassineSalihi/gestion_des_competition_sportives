package controller;

import com.google.gson.Gson;
import dao2.ResultatDao;
import org.entities.Competition;
import org.entities.Resultat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/statistiques")
public class StatistiquesController extends HttpServlet {
    private ResultatDao resultatDao;

    @Override
    public void init() {
        resultatDao = new ResultatDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Resultat> resultats = resultatDao.findAll();
        Map<String, Integer> stats = new LinkedHashMap<>();

        for (Resultat r : resultats) {
            String nom = r.getCompetition().getNom();
            stats.put(nom, stats.getOrDefault(nom, 0) + 1);
        }

        request.setAttribute("labels", stats.keySet());
        request.setAttribute("values", stats.values());

        request.setAttribute("labels", new Gson().toJson(stats.keySet()));
        request.setAttribute("values", new Gson().toJson(stats.values()));

        request.getRequestDispatcher("views/statistiques.jsp").forward(request, response);

    }
}
