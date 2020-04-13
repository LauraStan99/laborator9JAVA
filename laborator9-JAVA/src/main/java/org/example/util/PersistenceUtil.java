package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    static EntityManagerFactory emf;
    static EntityManager em;
    private PersistenceUtil(){

    }
    /*
     *creaza un obiect de tipul EntityManagerFactory , fiind o interfață utilizată pentru a interacționa
     * cu fabrica managerului de entitate ,metodea createEntityMaanger() fiind apelata ulterior cu scopul de a
     * crea o noua instanta EntityManager, la final returnand-o.
     */
    public static EntityManager createPersistence()
    {
        emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        em = emf.createEntityManager();
        return em;
    }


}
