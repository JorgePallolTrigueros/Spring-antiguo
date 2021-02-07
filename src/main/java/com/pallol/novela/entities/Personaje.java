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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CASA PALLOL
 */
@Entity
@Table(name = "personaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personaje.findAll", query = "SELECT p FROM Personaje p"),
    @NamedQuery(name = "Personaje.findByPersonajeId", query = "SELECT p FROM Personaje p WHERE p.personajeId = :personajeId"),
    @NamedQuery(name = "Personaje.findByNombre", query = "SELECT p FROM Personaje p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Personaje.findByDescripcion", query = "SELECT p FROM Personaje p WHERE p.descripcion = :descripcion")})
public class Personaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personaje_id")
    private Integer personajeId;
    @Size(max = 75)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Size(max = 65535)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "novela_id_fk", referencedColumnName = "novela_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novela novelaIdFk;

    public Personaje() {
    }

    public Personaje(Integer personajeId) {
        this.personajeId = personajeId;
    }

    public Integer getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(Integer personajeId) {
        this.personajeId = personajeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (personajeId != null ? personajeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personaje)) {
            return false;
        }
        Personaje other = (Personaje) object;
        if ((this.personajeId == null && other.personajeId != null) || (this.personajeId != null && !this.personajeId.equals(other.personajeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pallol.novela.entities.Personaje[ personajeId=" + personajeId + " ]";
    }
    
}
