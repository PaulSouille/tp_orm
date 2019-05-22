package fr.epsi.model;

import javax.persistence.*;
import java.util.Date;

public class Prelevement {


    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    private String commentaire;
    @ManyToOne
    @JoinColumn(name="qualitometre_id")
    private Qualitometre qualitometre;

    public Prelevement(Date dateHeure, String commentaire) {
        this.dateHeure = dateHeure;
        this.commentaire = commentaire;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
