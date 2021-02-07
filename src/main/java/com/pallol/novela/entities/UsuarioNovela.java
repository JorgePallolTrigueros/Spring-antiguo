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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CASA PALLOL
 */
@Entity
@Table(name = "usuario_novela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioNovela.findAll", query = "SELECT u FROM UsuarioNovela u"),
    @NamedQuery(name = "UsuarioNovela.findByUsuarioNovelaId", query = "SELECT u FROM UsuarioNovela u WHERE u.usuarioNovelaId = :usuarioNovelaId")})
public class UsuarioNovela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_novela_id")
    private Integer usuarioNovelaId;
    @JoinColumn(name = "novela_id_fk", referencedColumnName = "novela_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novela novelaIdFk;
    @JoinColumn(name = "usuario_id_fk", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdFk;

    public UsuarioNovela() {
    }

    public UsuarioNovela(Integer usuarioNovelaId) {
        this.usuarioNovelaId = usuarioNovelaId;
    }

    public Integer getUsuarioNovelaId() {
        return usuarioNovelaId;
    }

    public void setUsuarioNovelaId(Integer usuarioNovelaId) {
        this.usuarioNovelaId = usuarioNovelaId;
    }

    public Novela getNovelaIdFk() {
        return novelaIdFk;
    }

    public void setNovelaIdFk(Novela novelaIdFk) {
        this.novelaIdFk = novelaIdFk;
    }

    public Usuario getUsuarioIdFk() {
        return usuarioIdFk;
    }

    public void setUsuarioIdFk(Usuario usuarioIdFk) {
        this.usuarioIdFk = usuarioIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioNovelaId != null ? usuarioNovelaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioNovela)) {
            return false;
        }
        UsuarioNovela other = (UsuarioNovela) object;
        if ((this.usuarioNovelaId == null && other.usuarioNovelaId != null) || (this.usuarioNovelaId != null && !this.usuarioNovelaId.equals(other.usuarioNovelaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pallol.novela.entities.UsuarioNovela[ usuarioNovelaId=" + usuarioNovelaId + " ]";
    }
    
}
