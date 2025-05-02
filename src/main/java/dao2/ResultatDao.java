package dao2;

import org.entities.Resultat;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResultatDao extends AbstractDao<Resultat> {
    public ResultatDao() {
        super(Resultat.class);
    }

    public String getScoresParCompetitionJson() {
        JSONArray jsonArray = new JSONArray();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT r.competition.nom, AVG(r.score) FROM Resultat r GROUP BY r.competition.nom";
            Query<Object[]> query = session.createQuery(hql, Object[].class);

            for (Object[] row : query.list()) {
                JSONObject obj = new JSONObject();
                obj.put("nom", row[0]);
                obj.put("score", row[1]);
                jsonArray.put(obj);
            }
        }

        return jsonArray.toString();
    }
}
