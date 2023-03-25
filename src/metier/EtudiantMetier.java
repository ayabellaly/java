package metier;
import dao.daoMysql.EtudiantDao;
import lombok.*;
import modele.Etudiant;

import java.sql.Connection;

@Data
@AllArgsConstructor @NoArgsConstructor

public class EtudiantMetier implements Imetier{

    private Connection connection;



    EtudiantDao etudiantDao;

    public Etudiant Calculer_moyenne(Integer idEtudiant) throws Exception {
        var etudiant = etudiantDao.findbyid(idEtudiant);

        if (etudiant == null)
            throw new Exception("l id du note n'est pas disponible");
        else {

            double grade = etudiant.getGradesTotal();
            grade = grade / 100;
            if (grade >= 5) {
                System.out.printf("validé");
            } else {
                System.out.printf("non validé");
            }
            etudiant.setGradesTotal(grade);


        }
        return etudiant;
    }}





















