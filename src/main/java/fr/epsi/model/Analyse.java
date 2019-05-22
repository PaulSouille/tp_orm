package fr.epsi.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "analyse" ,indexes = @Index(columnList = "id"))
public class Analyse implements Serializable {


    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    private long resultat;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paramPhysicoChimique_id")
    private ParamPhysicoChimique paramPhysicoChimique;
    @ManyToOne
    @JoinColumn(name="prelevement_id")
    private Prelevement prelevement;

    public Analyse(Date dateHeure, long resultat, ParamPhysicoChimique paramPhysicoChimique, Prelevement prelevement) {
        this.dateHeure = dateHeure;
        this.resultat = resultat;
        this.paramPhysicoChimique = paramPhysicoChimique;
        this.prelevement = prelevement;
    }

    public Analyse() {
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

    public long getResultat() {
        return resultat;
    }

    public void setResultat(long resultat) {
        this.resultat = resultat;
    }

    public ParamPhysicoChimique getParamPhysicoChimique() {
        return paramPhysicoChimique;
    }

    public void setParamPhysicoChimique(ParamPhysicoChimique paramPhysicoChimique) {
        this.paramPhysicoChimique = paramPhysicoChimique;
    }

    public Prelevement getPrelevement() {
        return prelevement;
    }

    public void setPrelevement(Prelevement prelevement) {
        this.prelevement = prelevement;
    }
}
