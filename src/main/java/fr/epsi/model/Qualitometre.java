package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "qualitometre" ,indexes = @Index(columnList = "codeBSS"))
public class Qualitometre implements Serializable {


    @Id
    @Column(unique = true)
    private long codeBSS;
    private long latitude;
    private long longitude;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String commentaire;

    @OneToMany (cascade = CascadeType.ALL,mappedBy="qualitometre", fetch=FetchType.EAGER)
    private List<Prelevement> prelevements;




    public long getCodeBSS() {
        return codeBSS;
    }

    public void setCodeBSS(long codeBSS) {
        this.codeBSS = codeBSS;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }




}
