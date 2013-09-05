package MuistilistaPackage;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author miimaija
 */
public class Muistio implements Serializable {
    private Long muistioid;     //pkey
    private Kategoria kategoria;     //fkey
    private Long userid;        //fkey
    private int tarkeys;
    private String nimi;
    private String kuvaus;
    
    public Muistio() {
        //Älä käytä
    }
    
    public Muistio(Kategoria kategoria, long userid, int tarkeys, String kuvaus, String nimi) {
        this.userid=userid; this.tarkeys=tarkeys; this.kuvaus=kuvaus; this.nimi=nimi;
        this.kategoria=kategoria; 
    }

    public Long getId() {
        return muistioid;
    }
    
    public Kategoria getKategoria() {
        return kategoria;
    }
    
    public int getTarkeys() {
        return tarkeys;
    }
    
    public Long getUserId() {
        return userid;
    }
    
    public String getKuvaus() {
        return kuvaus;
    }
    
    public String getNimi() {
        return nimi;
    }

    public void setId(Long id) {
        this.muistioid = id;
    }
    
    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    } 
    
    public void setUserId(Long id) {
        this.userid = id;
    }
    
    public void setTarkeys(int tarkeys) {
        this.tarkeys = tarkeys;
    }
    
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (muistioid != null ? muistioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Muistio)) {
            return false;
        }
        Muistio other = (Muistio) object;
        if ((this.muistioid == null && other.muistioid != null) || (this.muistioid != null && !this.muistioid.equals(other.muistioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MuistilistaPackage.NewEntity[ id=" + muistioid + " ]";
    }
    
}
