/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MuistilistaPackage;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author miimaija
 */
public class Tietokanta {
    
    private EntityManagerFactory emf = null;

    public Tietokanta() {
        emf = Persistence.createEntityManagerFactory("MuistilistaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void lisaaKayttaja(Kayttaja uusi) {
        EntityManager em = getEntityManager();
	
        em.getTransaction().begin();	
        em.persist(uusi);
        em.getTransaction().commit();
    }
    
    public void lisaaTehtava(Tehtava uusi) {
        EntityManager em = getEntityManager();
	
        em.getTransaction().begin();	
        em.persist(uusi);
        em.getTransaction().commit();
    }

    public List<Kayttaja> getKayttajat() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Kayttaja u").getResultList();
    }
    
    public List<Tehtava> getTehtavat() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Tehtava u").getResultList();
    }

}




