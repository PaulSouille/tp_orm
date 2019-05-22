package fr.epsi.dao;

import fr.epsi.model.Analyse;
import fr.epsi.model.ParamPhysicoChimique;
import fr.epsi.model.Prelevement;
import fr.epsi.model.Qualitometre;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class QualitometreTest {

    @Test
    public void createData() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1998, Calendar.MAY, 15);
        Qualitometre qualitometre = new Qualitometre();
        qualitometre.setCodeBSS(126);
        qualitometre.setCommentaire("UN commentaire");
        qualitometre.setDateCreation(calendar.getTime());
        qualitometre.setLatitude(46);
        qualitometre.setLongitude(26);
        new QualitometreDao().save(qualitometre);

        ParamPhysicoChimique paramPhysicoChimique = new ParamPhysicoChimique();
        paramPhysicoChimique.setAuteur("paul");
        paramPhysicoChimique.setCode(126);
        paramPhysicoChimique.setStatut(ParamPhysicoChimique.Statut.Valide);

        paramPhysicoChimique.setDateCreation(calendar.getTime());
        paramPhysicoChimique.setName("Test");
        new ParamPhysicoChimiqueDao().save(paramPhysicoChimique);

        Prelevement prelevement = new Prelevement();
        prelevement.setDateHeure(calendar.getTime());
        prelevement.setCommentaire("Un commentaire");
        prelevement.setQualitometre(qualitometre);
        new PrelevementDao().save(prelevement);

        Analyse analyse = new Analyse();
        analyse.setDateHeure(calendar.getTime());
        analyse.setParamPhysicoChimique(paramPhysicoChimique);
        analyse.setPrelevement(prelevement);
        analyse.setResultat(1);
        new AnalyseDao().save(analyse);


    }

    @Test
    public void createAnalyse(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1998, Calendar.MAY, 15);

        Analyse analyse = new Analyse();
        analyse.setDateHeure(calendar.getTime());
        analyse.setParamPhysicoChimique(new ParamPhysicoChimiqueDao().get(126));
        analyse.setPrelevement(new PrelevementDao().get(6));
        analyse.setResultat(1);
        new AnalyseDao().save(analyse);

    }


    //Question 2 : la suppression d'un prelevement supprime les analyses
    // ( L'id étant autogénéré, il fautbien sur set celui qui est en base dans la méthode get)

    @Test
    public void deleteQualitometre(){
        Prelevement prelevement = new PrelevementDao().get(4);
        new PrelevementDao().delete(prelevement);
    }

    @Test
    public void GetMostAnalysedParam(){
        ParamPhysicoChimique paramPhysicoChimique = new ParamPhysicoChimique();
        System.out.println(paramPhysicoChimique.getMostAnalysedParam());
    }
    @Test
    public void GetMostAnalysedParamByQualitometre(){
        ParamPhysicoChimique paramPhysicoChimique = new ParamPhysicoChimique();
        Qualitometre qualitometre = new QualitometreDao().get(126);
        System.out.println(paramPhysicoChimique.getMostAnalysedParam(qualitometre));
    }

}
