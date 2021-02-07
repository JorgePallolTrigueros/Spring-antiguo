/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CASA PALLOL
 */
@Entity
@Table(name = "galeria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Galeria.findAll", query = "SELECT g FROM Galeria g"),
    @NamedQuery(name = "Galeria.findByGaleriaId", query = "SELECT g FROM Galeria g WHERE g.galeriaId = :galeriaId")})
public class Galeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "galeria_id")
    private Integer galeriaId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "novela_id_fk", referencedColumnName = "novela_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novela novelaIdFk;

    public Galeria() {
    }

    public Galeria(Integer galeriaId) {
        this.galeriaId = galeriaId;
    }

    public Galeria(Integer galeriaId, String url) {
        this.galeriaId = galeriaId;
        this.url = url;
    }

    public Integer getGaleriaId() {
        return galeriaId;
    }

    public void setGaleriaId(Integer galeriaId) {
        this.galeriaId = galeriaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Novela getNovelaIdFk() {
        return novelaIdFk;
    }

    public void setNovelaIdFk(Novela novelaIdFk) {
        this.novelaIdFk = novelaIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (galeriaId != null ? galeriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galeria)) {
            return false;
        }
        Galeria other = (Galeria) object;
        if ((this.galeriaId == null && other.galeriaId != null) || (this.galeriaId != null && !this.galeriaId.equals(other.galeriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pallol.novela.entities.Galeria[ galeriaId=" + galeriaId + " ]";
    }
    
}
