package dao;

import dao.daoMysql.FactoryMySQL;
import modele.Etudiant;

public abstract class Factory {



    public static final int MySQL_DAO_FACTORY = 0;
    public static final int File_DAO_FACTORY = 0;


    public abstract Idao<Etudiant,Long> getEtudiantDAO();

    public static Factory getFactory(int type){
        switch (type){
            case MySQL_DAO_FACTORY:
            return FactoryMySQL.Instance;
            case File_DAO_FACTORY:
                return new FactoryID();
            default:
                return null;

        }

    }





}
