/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author yassinesalihi
 */
public class TestHibernate {
    
   /* {
        System.out.println("non static 1");
    }
    
    static {
        System.out.println("static 1");
    }
    
    static {
        System.out.println("static 2");
    }
    
    
    {
        System.out.println("non static 2");
    }

    public TestHibernate() {
        System.out.println("construct");
    }
    */
    
    public static void main(String[] args) {
        //new TestHibernate();
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            System.out.println("✅ Connexion réussie !");
            session.beginTransaction();

            // Exemple de test :
            /*ProduitService ps = new ProduitService();
            ps.setNom("Nom test");
            ps.setType("Service");

            session.save(ps);
            session.getTransaction().commit();
            System.out.println("🟢 ProduitService enregistré.");
        } catch (Exception e) {
            System.err.println("❌ Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
    }*/
        }
    }
}
