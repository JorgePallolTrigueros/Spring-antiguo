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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CASA PALLOL
 */
@Entity
@Table(name = "capitulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capitulo.findAll", query = "SELECT c FROM Capitulo c"),
    @NamedQuery(name = "Capitulo.findByCapituloId", query = "SELECT c FROM Capitulo c WHERE c.capituloId = :capituloId"),
    @NamedQuery(name = "Capitulo.findByNombre", query = "SELECT c FROM Capitulo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Capitulo.findByOrden", query = "SELECT c FROM Capitulo c WHERE c.orden = :orden")})
public class Capitulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "capitulo_id")
    private Integer capituloId;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "orden")
    private String orden;
    @JoinColumn(name = "novela_id_fk", referencedColumnName = "novela_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novela novelaIdFk;

    public Capitulo() {
    }

    public Capitulo(Integer capituloId) {
        this.capituloId = capituloId;
    }

    public Integer getCapituloId() {
        return capituloId;
    }

    public void setCapituloId(Integer capituloId) {
        this.capituloId = capituloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
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
        hash += (capituloId != null ? capituloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capitulo)) {
            return false;
        }
        Capitulo other = (Capitulo) object;
        if ((this.capituloId == null && other.capituloId != null) || (this.capituloId != null && !this.capituloId.equals(other.capituloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pallol.novela.entities.Capitulo[ capituloId=" + capituloId + " ]";
    }
    
}
