/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CASA PALLOL
 */
@Entity
@Table(name = "compra_realizada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraRealizada.findAll", query = "SELECT c FROM CompraRealizada c"),
    @NamedQuery(name = "CompraRealizada.findByCompraRealizadaId", query = "SELECT c FROM CompraRealizada c WHERE c.compraRealizadaId = :compraRealizadaId"),
    @NamedQuery(name = "CompraRealizada.findByMontoTotal", query = "SELECT c FROM CompraRealizada c WHERE c.montoTotal = :montoTotal"),
    @NamedQuery(name = "CompraRealizada.findByRealizada", query = "SELECT c FROM CompraRealizada c WHERE c.realizada = :realizada"),
    @NamedQuery(name = "CompraRealizada.findByFechaCreacion", query = "SELECT c FROM CompraRealizada c WHERE c.fechaCreacion = :fechaCreacion")})
public class CompraRealizada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "compra_realizada_id")
    private Integer compraRealizadaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_total")
    private int montoTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "realizada")
    private boolean realizada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "idusuario", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuario;

    public CompraRealizada() {
    }

    public CompraRealizada(Integer compraRealizadaId) {
        this.compraRealizadaId = compraRealizadaId;
    }

    public CompraRealizada(Integer compraRealizadaId, int montoTotal, boolean realizada, Date fechaCreacion) {
        this.compraRealizadaId = compraRealizadaId;
        this.montoTotal = montoTotal;
        this.realizada = realizada;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCompraRealizadaId() {
        return compraRealizadaId;
    }

    public void setCompraRealizadaId(Integer compraRealizadaId) {
        this.compraRealizadaId = compraRealizadaId;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraRealizadaId != null ? compraRealizadaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraRealizada)) {
            return false;
        }
        CompraRealizada other = (CompraRealizada) object;
        if ((this.compraRealizadaId == null && other.compraRealizadaId != null) || (this.compraRealizadaId != null && !this.compraRealizadaId.equals(other.compraRealizadaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pallol.novela.entities.CompraRealizada[ compraRealizadaId=" + compraRealizadaId + " ]";
    }
    
}
