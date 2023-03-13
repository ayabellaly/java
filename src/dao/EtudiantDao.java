package dao;


import modele.Etudiant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor

public class EtudiantDao {

public static Set<Etudiant>BDEtudiant(){
    return new HashSet<Etudiant>(
            Arrays.asList(


                    new Etudiant(1,"AYA",70.0),
                    new Etudiant(2,"HIBA",60.0),
                    new Etudiant(3,"ANISSA",50.0)

            ));
}
public Etudiant trouverParId(Integer id){

    System.out.printf("trouver la note par Id:"+id);
    return BDEtudiant().stream().filter(etudiant -> etudiant.getId()==id).findFirst().orElse(null);




}











}
