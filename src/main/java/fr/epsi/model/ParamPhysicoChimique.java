package fr.epsi.model;



import fr.epsi.dao.AbstractDao;
import fr.epsi.dao.ParamPhysicoChimiqueDao;
import fr.epsi.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paramPhysicoChimique" ,indexes = @Index(columnList = "code"))
public class ParamPhysicoChimique implements Serializable {

    @Id
    @Column(unique = true)
    private long code;
    private String name;
    private Statut statut;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String auteur;



    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    public List<ParamPhysicoChimique> getMostAnalysedParam(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List paramPhysicoChimiqueList = session.createSQLQuery("select PARAMPHYSICOCHIMIQUE.code,PARAMPHYSICOCHIMIQUE.AUTEUR,PARAMPHYSICOCHIMIQUE.DATECREATION,PARAMPHYSICOCHIMIQUE.NAME,PARAMPHYSICOCHIMIQUE.STATUT from PARAMPHYSICOCHIMIQUE, ANALYSE  where analyse.PARAMPHYSICOCHIMIQUE_id = PARAMPHYSICOCHIMIQUE.code GROUP BY PARAMPHYSICOCHIMIQUE.code ORDER BY count(ANALSE.*)").list();
        return paramPhysicoChimiqueList;
    }

    public List<ParamPhysicoChimique> getMostAnalysedParam(Qualitometre qualitometre){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List paramPhysicoChimiqueList = session.createSQLQuery("select PARAMPHYSICOCHIMIQUE.code,PARAMPHYSICOCHIMIQUE.AUTEUR,PARAMPHYSICOCHIMIQUE.DATECREATION,PARAMPHYSICOCHIMIQUE.NAME,PARAMPHYSICOCHIMIQUE.STATUT from PARAMPHYSICOCHIMIQUE, ANALYSE,PRELEVEMENT,QUALITOMETRE  where analyse.PARAMPHYSICOCHIMIQUE_id = PARAMPHYSICOCHIMIQUE.code and analyse.prelevement_id = prelevement.id  and PRELEVEMENT.QUALITOMETRE_ID = "+qualitometre.getCodeBSS()+"GROUP BY PARAMPHYSICOCHIMIQUE.code ORDER BY count(ANALSE.*)").list();
        return paramPhysicoChimiqueList;
    }

    public enum Statut {
        Gele( "gelé" ), Valide( "validé" );

        private String value;

        Statut( String value ) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

