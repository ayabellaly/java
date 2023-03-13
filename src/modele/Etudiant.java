package modele;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor

public class Etudiant {
    private Integer id;

    private String name;

    private double gradesTotal;









    @Override
    public String toString() {
        var EtudiantStr="================================================" ;
                EtudiantStr+=", id=" + id +'\'' ;
                EtudiantStr+="name='" + name +'\'' ;
                EtudiantStr+= ", averageGrade=" + gradesTotal +'\'' ;
            EtudiantStr="================================================" ;

                return EtudiantStr;


    }





















}










