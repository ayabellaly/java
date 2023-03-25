package dao;

import modele.Etudiant;

import java.util.List;

public interface Idao<E, I> {



    E findbyid( int ide);
    E  save(E etudiant);
    List<E> findAll();
    E update( E etudiant);
    E delete( E etudiant);




}
