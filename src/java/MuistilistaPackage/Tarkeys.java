package MuistilistaPackage;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author miimaija
 * OBSOLETE!?!?!? lisätään tehtävän sisälle
 */
@Entity
public class Tarkeys implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tarkeys;        //pkey
    
    @Column
    private String kuvaus;
    
    public Tarkeys() {
        
    }

    public int getId() {
        return tarkeys;
    }
    
    public String getKuvaus() {
        return kuvaus;
    }

    /*public void setId(int id) {          ei muuteta tärkeyksiä
        this.Tarkeys = id;
    }   */
    
    public void setKuvaus(String kuvaus) {
        this.kuvaus=kuvaus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tarkeys;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Tarkeys fields are not set
        if (!(object instanceof Tarkeys)) {
            return false;
        }
        Tarkeys other = (Tarkeys) object;
        if (this.tarkeys != other.tarkeys) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MuistilistaPackage.tarkeys[ id=" + tarkeys + " ]";
    }
    
}
