package MuistilistaPackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miimaija
 */
public class Tietokanta {
    Connection yhteys = null;
    PreparedStatement kysely = null;
    ResultSet tulokset = null;
 
    public Tietokanta() {
                          
    }
    
    protected void luoYhteys() throws SQLException {      
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            yhteys = DriverManager.getConnection("jdbc:mysql://localhost/muistilista?user=miimaija&password=u"); 
        }catch (Exception e) {}             
    }
    
    protected void lopetaYhteys() throws SQLException {
        try { tulokset.close(); } catch (Exception e) {  }
        try { kysely.close(); } catch (Exception e) {  }
        try { yhteys.close(); } catch (Exception e) {  }
    }  

    public void lisaaKayttaja(Kayttaja uusi) throws SQLException {
        luoYhteys();
        PreparedStatement prepareStatement = yhteys.prepareStatement("INSERT INTO KAYTTAJA VALUES ("+ uusi.getId() +","+ uusi.getSalasana() +","+ uusi.getTunnus() +")");
        ResultSet resultSet = prepareStatement.executeQuery();
        lopetaYhteys();
    }
    
    public void lisaaMuistio(Muistio uusi) {
        
    }
    
     public void lisaaKategoria(Kategoria uusi) {
        
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
        
    }

    public void poistaMuistio(Muistio poisto) {
        
    }
    
    public void poistaKategoria(Kategoria poisto) {
        
    }
    
    public List<Kayttaja> getKayttajat() throws SQLException {
        List<Kayttaja> lista=new ArrayList<Kayttaja>();
        luoYhteys();
        PreparedStatement prepareStatement = yhteys.prepareStatement("SELECT * FROM Kayttaja");
        
        if (prepareStatement.execute()) {
            ResultSet resultSet = prepareStatement.getResultSet();
            while (resultSet.next()) {
                lista.add(new Kayttaja(resultSet.getString("TUNNUS"),resultSet.getString("SALASANA"), resultSet.getLong("USERID")));
            }
        }
        
        lopetaYhteys();
        return lista;
    }
       
    public List<Muistio> getMuistiot(long userid) {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Muistio u WHERE u.userid = " + userid).getResultList();
        
        //   return em.createQuery("SELECT u FROM Muistio WHERE USERID=" + userid).getResultList(); EI?? WTF!?!?
        
        //   SELECT e FROM Employee e WHERE e.name = :name")
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
    
    public Kategoria getKategoria(long kategorid) {
        Kategoria apu;
        EntityManager em = getEntityManager();
        List<Kategoria> lista=em.createQuery("SELECT u FROM Kategoria u").getResultList(); // Hyi miten hidas jos oikeasti käytössä
        for (int i=0; lista.size()>i; i++) {
            if (lista.get(i).getId().equals(kategorid)) {
                apu=lista.get(i);
                return apu;
            }
        }
        return null; 
    }
    
    public List<Kategoria> getKategoriat(long userid) {
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




