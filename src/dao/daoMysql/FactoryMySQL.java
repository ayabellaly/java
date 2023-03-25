package dao.daoMysql;

import dao.Factory;
import dao.Idao;
import modele.Etudiant;

import java.sql.Connection;


public class FactoryMySQL extends Factory {

    public static  FactoryMySQL INSTANCE = getInstance();

    private static Connection connection;

    private String url,login,pass;


    public static Connection getConnection(){ return null;}

    public static void closeConnection(){}
    public static FactoryMySQL getInstance(){
       return null;
    }


    @Override
    public Idao<Etudiant, Long> getEtudiantDAO() {
        return new EtudiantDao();
    }





}
