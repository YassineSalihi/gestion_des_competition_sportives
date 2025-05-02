package org.entities;

import java.util.Date;
import java.util.List;
import java.text.ParseException; // for constructor
import java.text.SimpleDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compettion")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String type;
    @Column(name = "date_debut")
    private Date dateDebut;
    @Column(name = "date_fin")
    private Date dateFin;
    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Resultat> resultats;


    public Competition() {
    }

    public Competition(String nom, String type, String dateDebutStr, String dateFinStr) {
        this.nom = nom;
        this.type = type;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.dateDebut = sdf.parse(dateDebutStr);
            this.dateFin = sdf.parse(dateFinStr);
        } catch (ParseException e) {
            throw new RuntimeException("Erreur lors du parsing des dates", e);
        }
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public List<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }



}
