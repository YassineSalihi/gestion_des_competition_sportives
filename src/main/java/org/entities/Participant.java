package org.entities;

import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "participant")
public class Participant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String categorie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // nom de la colonne dans la base
    private User user;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Resultat> resultats;

    public Participant() {
    }

    public Participant(int id, String nom, String categorie, List<Resultat> resultats) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.resultats = resultats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }


}