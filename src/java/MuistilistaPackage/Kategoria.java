package MuistilistaPackage;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author miimaija
 */
public class Kategoria implements Serializable {
    private Long kategorid; //pkey
    private Long userid; //fkey
    private List<Muistio> muistiot;
    private String nimi;
    
    public Kategoria() {
        
    }

    public Kategoria(Long userid, String nimi) {
        this.userid=userid;this.nimi=nimi;
    }

    public List<Muistio> getMuistiot() {
        return muistiot;
    }
    
    public Long getId() {
        return kategorid;
    }
    
    public Long getUserId() {
        return userid;
    }
    
    public String getNimi() {
        return nimi;
    }

    public void setId(Long id) {
        this.kategorid = id;
    }
    
    public void setUserId(Long id) {
        this.userid = id;
    }
    
    public void setnimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategorid != null ? kategorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the kategorid fields are not set
        if (!(object instanceof Kategoria)) {
            return false;
        }
        Kategoria other = (Kategoria) object;
        if ((this.kategorid == null && other.kategorid != null) || (this.kategorid != null && !this.kategorid.equals(other.kategorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MuistilistaPackage.kategoria[ id=" + kategorid + " ]";
    }
    
}