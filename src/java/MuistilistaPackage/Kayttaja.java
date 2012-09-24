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
 */
@Entity
public class Kayttaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;
    
    @Column
    private String tunnus;
    
    @Column
    private String salasana;
    
    public Kayttaja() {
    
    }
    
    public Kayttaja(String tunnus, String salasana) {
        this.salasana=salasana;this.tunnus=tunnus;
    }

    public Long getId() {
        return userid;
    }
    
    public String getTunnus() {
        return tunnus;
    }
    
    public String getSalasana() {
        return salasana;
    }

    public void setId(Long id) {
        this.userid = id;
    }
    
    public void setTunnus(String tunnus) {
        this.tunnus=tunnus;
    }
    
    public void setSalasana(String salasana) {
        this.salasana=salasana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the userid fields are not set
        if (!(object instanceof Kayttaja)) {
            return false;
        }
        Kayttaja other = (Kayttaja) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MuistilistaPackage.kayttaja[ id=" + userid + " ]";
    }
    
}
