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
     
    public void muokkaaMuistio(long muistiod) {        
        EntityManager em = getEntityManager();
	
        em.getTransaction().begin();
        //em.createQuery("SELECT u FROM Muistio u WHERE u.muistioid = " + muistiod).setParameter("String", object); //TOIMIIKO!?
        //em.refresh(MITÄ TÄHÄN!?!?)
        em.getTransaction().commit();
    } 

    public List<Kayttaja> getKayttajat() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Kayttaja u").getResultList();
    }
    
    public Kayttaja tunnistaKayttaja(String tunnus, String salasana) {
        return null;  // datahaku tee?
    }
    
    public Muistio getMuistio(long muistioid, long userid) {
        List<Muistio> lista=getMuistiot(userid);
        for (int i=0;lista.size()>i; i++) {
            if (lista.get(i).getId().equals(muistioid)) {
                return lista.get(i);
            }
        }
        return null;  //Ei pitäisi olla mahdollista, id on haettu alunperin db:n kautta, joten aina löytyy. 
    }
    
    public List<Muistio> getMuistiot(long userid) {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Muistio u WHERE u.userid = " + userid).getResultList();
        
        //   return em.createQuery("SELECT u FROM Muistio WHERE USERID=" + userid).getResultList(); EI?? WTF!?!?
        
        //   SELECT e FROM Employee e WHERE e.name = :name")
    }
    
    public List<Kategoria> getKategoria(long userid) {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Kategoria u WHERE u.userid = " + userid).getResultList();
    }
    
    public Long getKategorId(String nimi, Long userid) {
        EntityManager em = getEntityManager();
        List<Kategoria> lista=em.createQuery("SELECT u FROM Kategoria u").getResultList();
        for (int i=0; lista.size()>i; i++) {
            if (lista.get(i).getNimi().equalsIgnoreCase(nimi)) {    // haetaan nimi
                if (lista.get(i).getUserId().equals(userid)) {     //varmistetaan, että kategoria kuuluu tälle käyttäjälle
                    return lista.get(i).getId();
                }
            }
        }
        return (long)-999;    //Ei pitäisi olla mahdollista, nimi on haettu alunperin db:n kautta, joten aina löytyy
    }

}




