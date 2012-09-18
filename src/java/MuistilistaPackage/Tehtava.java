/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Tehtava implements Serializable {
    private static final long serialVersionUID = 1L;  // tarpeellinen??
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tehtavaid;     //pkey
    
    @Column
    private Long kategorid;     //fkey
    
    @Column
    private Long userid;        //fkey
    
    @Column
    private int tarkeys;        //fkey
    
    @Column
    private String kuvaus;
    
    public Tehtava() {
        
    }
    
    public Tehtava(long kategorid, long userid, int tarkeys, String kuvaus) {
        this.kategorid=kategorid; this.userid=userid; this.tarkeys=tarkeys; this.kuvaus=kuvaus;
    }

    public Long getId() {
        return tehtavaid;
    }
    
    public Long getKategoria() {
        return kategorid;
    }
    
    public int getTarkeus() {
        return tarkeys;
    }
    
    public Long getUserId() {
        return userid;
    }
    
    public String getKuvaus() {
        return kuvaus;
    }

    public void setId(Long id) {
        this.tehtavaid = id;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tehtavaid != null ? tehtavaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tehtava)) {
            return false;
        }
        Tehtava other = (Tehtava) object;
        if ((this.tehtavaid == null && other.tehtavaid != null) || (this.tehtavaid != null && !this.tehtavaid.equals(other.tehtavaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MuistilistaPackage.NewEntity[ id=" + tehtavaid + " ]";
    }
    
}
