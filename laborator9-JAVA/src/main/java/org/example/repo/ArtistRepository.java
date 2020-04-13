package org.example.repo;

import org.example.entity.Artists;
import org.example.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ArtistRepository {

    public ArtistRepository() {

    }
/*
* dupa crearea unei noi instante EntityManager , se apeleaza functia getTransaction().begin() ,
* returnand obiectul EntityTransaction la nivel de resursa ,folosita pentru a incepe si da commit tranzitiilor create,
*  dupa care se inchide managerul de entitate pentru a elibera contextul sau de persistenta si alte resurse.
*/
    public void create(Artists artist) {
        EntityManager entityManager = PersistenceUtil.createPersistence();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
/*
* dupa crearea unei noi instante EntityManager , se scrie noua comanda sql de cautare a obiectului in
*  functie de parametrul functiei (setandu-l cu ajutorul functiei setParameter() obiectului de tip Query) ,
*  dupa care se inchide menegerul entitate,in caz ca lista obtinuta (o lista de tipul obiectelor Artists) nu
* este goala se returneaza primul obiect gasit
*/
    public Artists findByName(String artistName) {
        EntityManager entityManager = PersistenceUtil.createPersistence();
        Query query = entityManager.createQuery("select a from Artists a where a.name like :name");

        List<Artists> artists = query.setParameter("name", artistName).getResultList();
        entityManager.close();

        return artists.isEmpty() ? null : artists.get(0);
    }
/*
 * dupa crearea unei noi instante EntityManager , se scrie noua comanda sql de cautare a obiectului in
 * functie de parametrul functiei (setandu-l cu ajutorul functiei setParameter() obiectului de tip Query) , un idArtist,
 * dupa care se inchide menegerul entitate,in caz ca lista obtinuta (o lista de tipul obiectelor Artists) nu
 * este goala se returneaza primul obiect gasit*/
    public Artists findById(Integer idArtist) {
        EntityManager entityManager = PersistenceUtil.createPersistence();
        Query query = entityManager.createQuery("select a from Artists a where a.id = :id");

        List<Artists> id = query.setParameter("id", idArtist).getResultList();
        entityManager.close();

        return id.isEmpty() ? null : id.get(0);
    }
/*
* face exact acelasi lucru ca metoda findByName(), doar ca parametrul oferit este un idArtist
* aceasta clasa contine in plus metoda findByArtist(..) care are ca si parametru un obiect de tipul Artists
* =>dupa crearea unei noi instante EntityManager , unui obiect de tipul Artist instanta apelandu-i o comanda sql
* deja definita in Clasa entitate Artists si returnand rezultatul;
*/
    public Artists findByArtist(Artists artist) {
        EntityManager emf = PersistenceUtil.createPersistence();

        Artists art = (Artists) emf.createNamedQuery("findByArtist")
                .setParameter("artist", artist)
                .getSingleResult();
        return art;
    }
}

