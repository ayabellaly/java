package presentation;
import lombok.*;
import metier.EtudiantMetier;

@Data
@AllArgsConstructor @NoArgsConstructor

public class EtudiantControlleur implements Ipresentation{

    EtudiantMetier etudiantMetier;

    public void afficher_moyenne(Integer idEtudiant) throws Exception{
        var grades = etudiantMetier.Calculer_moyenne(idEtudiant);
        System.out.println(grades);
    }


}
