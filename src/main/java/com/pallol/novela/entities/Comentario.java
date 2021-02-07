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
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByComentarioId", query = "SELECT c FROM Comentario c WHERE c.comentarioId = :comentarioId")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comentario_id")
    private Integer comentarioId;
    @Lob
    @Size(max = 65535)
    @Column(name = "texto")
    private String texto;
    @JoinColumn(name = "novela_id_fk", referencedColumnName = "novela_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novela novelaIdFk;
    @JoinColumn(name = "usuario_id_fk", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdFk;

    public Comentario() {
    }

    public Comentario(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Integer getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        hash += (comentarioId != null ? comentarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioId == null && other.comentarioId != null) || (this.comentarioId != null && !this.comentarioId.equals(other.comentarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pallol.novela.entities.Comentario[ comentarioId=" + comentarioId + " ]";
    }
    
}
