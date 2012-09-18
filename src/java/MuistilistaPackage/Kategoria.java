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
public class Kategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kategorid;     //pkey
    
    @Column
    private Long userid;        //fkey
    
    @Column
    private String nimi;
    
    @Column
    private Long ylakategoria;
    
    public Kategoria() {
        
    }
    
    public Kategoria(Long userid, String nimi, Long ylakategoria) {
        this.userid=userid;this.nimi=nimi;this.ylakategoria=ylakategoria;
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
    
    public Long getYlakategoria() {
        return ylakategoria;
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
    
    public void setYlakategoria(Long id) {
        this.ylakategoria = id;
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
