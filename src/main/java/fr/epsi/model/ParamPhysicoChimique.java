package fr.epsi.model;



import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class ParamPhysicoChimique {

    @Id
    @Column(unique = true)
    private long code;
    private String name;
    private Statut statut;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String auteur;




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

