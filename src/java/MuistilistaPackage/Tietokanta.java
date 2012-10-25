package MuistilistaPackage;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

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
    
     /*
    public void muokkaaMuistio2(long muistioid, long kategorid, long kayttajaid, String nimi, int tarkeys, String teksti) {        
        EntityManager em = getEntityManager();
	
        em.getTransaction().begin();
        //em.createQuery("SELECT u FROM Muistio u WHERE u.muistioid = " + muistiod).setParameter("String", object); //TOIMIIKO!?
        //em.refresh(MITÄ TÄHÄN!?!?) // D'oh 
        
        //UPDATE table_name SET column_name1=value1, column_name2=value2, ... [WHERE where_clause]
        em.createQuery("UPDATE Muistio u SET u.muistioid="+muistioid+", u.kategorid="+kategorid+", u.kuvaus="+teksti+", u.nimi="+nimi+
                ", u.tarkeys="+tarkeys+", u.userid="+kayttajaid+" WHERE u.muistioid = "+muistioid);
        em.getTransaction().commit();
        
        //CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        //cq.select(cq.from(Musitio.class));
        //Query q = em.createQuery(cq);
    } 
    * */
    
    public void muokkaaMuistio(Muistio muokkaus) {
        EntityManager em = getEntityManager();
	
        em.getTransaction().begin();	
        em.merge(muokkaus);
        em.getTransaction().commit();
    }

    public List<Kayttaja> getKayttajat() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Kayttaja u").getResultList();
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




