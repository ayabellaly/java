import dao.EtudiantDao;
import dao.Idao;
import metier.EtudiantMetier;
import metier.Imetier;
import modele.Etudiant;
import presentation.EtudiantControlleur;
import presentation.Ipresentation;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class SimulateurDeNoteEtu_App {



    static Scanner clavier = new Scanner(System.in);
    private static boolean estUnNombre(String input) {
        try {Integer.parseInt(input);
            return true;

        }catch (Exception e){
            return false;
        }
    }




    public static void test1(){

        var dao =new EtudiantDao();
        var metier =new EtudiantMetier();
        var controleur = new EtudiantControlleur();

        metier.setEtudiantDao(dao);
        controleur.setEtudiantMetier(metier);

        String rep = "";

        do {
            System.out.println("calcule de note des etudiants");
            try {
                String input = "";
                while (true) {
                    System.out.print("entrer l id de l'etudiant :");
                    input = clavier.nextLine();
                    if (estUnNombre(input)) break;
                    System.err.println("entree non valide ");
                }
                Integer id = Integer.parseInt(input);
                controleur.afficher_moyenne(id);

            } catch (Exception e) {
                System.err.printf(e.getMessage());
            }

            System.out.printf("voulez vous quitter (Oui/Non)?");
            rep = clavier.nextLine();


        }
        while (!rep.equalsIgnoreCase("Oui"));
        System.out.printf("AU revoir ^_^");






    }





    public static void test2() throws Exception {
        String daoClass;
        String serviceClass;
        String controllerClass;

        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream("config.properties");
        if (propertiesFile == null) throw new Exception("fichier config introuvable !!!");
        else {
            try {
                properties.load(propertiesFile);
                daoClass = properties.getProperty("Dao");
                serviceClass = properties.getProperty("Service");
                controllerClass = properties.getProperty("Controleur");
                propertiesFile.close();
            } catch (IOException e) {
                throw new Exception("probleme de chargement des propriété du fichier config");
            } finally {
                properties.clear();
            }
            try {
                Class cDao = Class.forName(daoClass);
                Class cMetier = Class.forName(serviceClass);
                Class cControleur = Class.forName(controllerClass);


                var dao = (Idao<Etudiant, Long>) cDao.getDeclaredConstructor().newInstance();
                var metier = (Imetier) cMetier.getDeclaredConstructor().newInstance();
                var etudiantControleur = (Ipresentation) cControleur.getDeclaredConstructor().newInstance();

                Method setDao = cMetier.getMethod("setEtudiantDao", EtudiantDao.class);
                setDao.invoke(metier, dao);

                Method setMetier = cControleur.getMethod("setEtudiantMetier", EtudiantMetier.class);
                setDao.invoke(etudiantControleur, metier);


                etudiantControleur.afficher_moyenne(1);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    public static void main(String[] args) { test1();

    }
}