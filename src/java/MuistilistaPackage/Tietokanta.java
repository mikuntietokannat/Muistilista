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
    
    public void lisaaMuistio(Muistio uusi) {
        EntityManager em = getEntityManager();
	
        em.getTransaction().begin();	
        em.persist(uusi);
        em.getTransaction().commit();
    }
    
     public void lisaaKategoria(Kategoria uusi) {
        EntityManager em = getEntityManager();
	
        em.getTransaction().begin();	
        em.persist(uusi);
        em.getTransaction().commit();
    }

    public List<Kayttaja> getKayttajat() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Kayttaja u").getResultList();
    }
    
    public Kayttaja tunnistaKayttaja(String tunnus, String salasana) {
        return null;  // datahaku TEE!!!!!!!!!!!!!!!!!!!!!!!!!11
    }
    
    public List<Muistio> getTehtavat() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Muistio u").getResultList();
    }
    
    public List<Kategoria> getKategoria() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Kategoria u").getResultList();
    }
    
    public Long getKategorId(String nimi) {
        EntityManager em = getEntityManager();
        List<Kategoria> lista=em.createQuery("SELECT u FROM Kategoria u").getResultList();
        for (int i=0; lista.size()>i; i++) {
            if (lista.get(i).getNimi().equals(nimi)) {
                return lista.get(i).getId();
            }
        }
        return (long)-999;    //Ei pitäisi olla mahdollista, nimi on haettu alunperin db:n kautta, joten aina löytyy
    }

}




