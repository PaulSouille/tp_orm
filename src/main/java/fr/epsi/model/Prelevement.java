package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "prelevement" ,indexes = @Index(columnList = "id"))
public class Prelevement implements Serializable {


    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    private String commentaire;
    @ManyToOne
    @JoinColumn(name="qualitometre_id")
    private Qualitometre qualitometre;


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

    public Qualitometre getQualitometre() {
        return qualitometre;
    }

    public void setQualitometre(Qualitometre qualitometre) {
        this.qualitometre = qualitometre;
    }


}
