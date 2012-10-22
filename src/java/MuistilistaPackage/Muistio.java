package MuistilistaPackage;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author miimaija
 */
@Entity
public class Muistio implements Serializable {
    private static final long serialVersionUID = 1L;  // tarpeellinen??
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long muistioid;     //pkey
    
    @JoinColumn
    private Long kategorid;     //fkey
    
    @JoinColumn
    private Long userid;        //fkey
    
    @Column
    private int tarkeys;
    
    @Column
    private String nimi;
    
    @Column
    private String kuvaus;
    
    public Muistio() {
        
    }
    
    public Muistio(long kategorid, long userid, int tarkeys, String kuvaus, String nimi) {
        this.kategorid=kategorid; this.userid=userid; this.tarkeys=tarkeys; this.kuvaus=kuvaus; this.nimi=nimi;
    }

    public Long getId() {
        return muistioid;
    }
    
    public Long getKategoria() {
        return kategorid;
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
    
    public void setKategoria(Long id) {
        this.kategorid = id;
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
