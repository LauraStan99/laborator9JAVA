package org.example.repo;


import org.example.entity.Albums;
import org.example.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {

    public AlbumRepository(){

    }
/*
* dupa crearea unei noi instante EntityManager , se apeleaza functia getTransaction().begin() ,
* returnand obiectul EntityTransaction la nivel de resursa ,folosita pentru a incepe si da commit tranzitiilor create,
* dupa care se inchide managerul de entitate pentru a elibera contextul sau de persistenta si alte resurse.
*/
    public void create(Albums album){
        EntityManager entityManager=  PersistenceUtil.createPersistence();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /*
    * dupa crearea unei noi instante EntityManager , se scrie noua comanda sql de cautare a obiectului
    * in functie de parametrul functiei (setandu-l cu ajutorul functiei setParameter() obiectului de tip Query) ,
    *  dupa care se inchide menegerul entitate,in caz ca lista obtinuta (o lista de tipul obiectelor Albums ) nu este goala
    * se returneaza primul obiect gasit
    */
    public Albums findByName(String albumName) {
        EntityManager entityManager = PersistenceUtil.createPersistence();
        Query query = entityManager.createQuery("select a from Albums a where a.name like :name");

        List<Albums> albums = query.setParameter("name",albumName).getResultList();
        entityManager.close();

        return albums.isEmpty() ? null : albums.get(0);
    }
    /*
    * dupa crearea unei noi instante EntityManager , se scrie noua comanda sql de cautare a obiectului
    * in functie de parametrul functiei (setandu-l cu ajutorul functiei setParameter() obiectului de tip Query) , un idAlbum,
    * dupa care se inchide menegerul entitate,in caz ca lista obtinuta (o lista de tipul obiectelor Albums ) nu este goala
    * se returneaza primul obiect gasit */
    public Albums findById(Integer idAlbum)
    {
        EntityManager entityManager =PersistenceUtil.createPersistence();
        Query query = entityManager.createQuery("select a from Albums a where a.id = :id");

        List<Albums> idAlbums = query.setParameter("id",idAlbum).getResultList();
        entityManager.close();

        return idAlbums.isEmpty() ? null : idAlbums.get(0);
    }
}
