/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CASA PALLOL
 */
@Entity
@Table(name = "novela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novela.findAll", query = "SELECT n FROM Novela n"),
    @NamedQuery(name = "Novela.findByNovelaId", query = "SELECT n FROM Novela n WHERE n.novelaId = :novelaId"),
    @NamedQuery(name = "Novela.findByNombre", query = "SELECT n FROM Novela n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "Novela.findByPrecio", query = "SELECT n FROM Novela n WHERE n.precio = :precio"),
    @NamedQuery(name = "Novela.findByNotas", query = "SELECT n FROM Novela n WHERE n.notas = :notas"),
    @NamedQuery(name = "Novela.findByVotos", query = "SELECT n FROM Novela n WHERE n.votos = :votos")})
public class Novela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "novela_id")
    private Integer novelaId;
    @Size(max = 75)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripciong")
    private String descripciong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "notas")
    private String notas;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "anotacion")
    private String anotacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcionp")
    private String descripcionp;
    @Column(name = "votos")
    private Integer votos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "novelaIdFk", fetch = FetchType.LAZY)
    private List<UsuarioNovela> usuarioNovelaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "novelaIdFk", fetch = FetchType.LAZY)
    private List<Comentario> comentarioList;
    @JoinColumn(name = "categoria_id_fk", referencedColumnName = "categoria_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoriaIdFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "novelaIdFk", fetch = FetchType.LAZY)
    private List<Capitulo> capituloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "novelaIdFk", fetch = FetchType.LAZY)
    private List<Personaje> personajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "novelaIdFk", fetch = FetchType.LAZY)
    private List<Galeria> galeriaList;

    public Novela() {
    }

    public Novela(Integer novelaId) {
        this.novelaId = novelaId;
    }

    public Novela(Integer novelaId, String descripciong, int precio, String notas, String anotacion, String imagen, String descripcionp) {
        this.novelaId = novelaId;
        this.descripciong = descripciong;
        this.precio = precio;
        this.notas = notas;
        this.anotacion = anotacion;
        this.imagen = imagen;
        this.descripcionp = descripcionp;
    }

    public Integer getNovelaId() {
        return novelaId;
    }

    public void setNovelaId(Integer novelaId) {
        this.novelaId = novelaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripciong() {
        return descripciong;
    }

    public void setDescripciong(String descripciong) {
        this.descripciong = descripciong;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcionp() {
        return descripcionp;
    }

    public void setDescripcionp(String descripcionp) {
        this.descripcionp = descripcionp;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    @XmlTransient
    public List<UsuarioNovela> getUsuarioNovelaList() {
        return usuarioNovelaList;
    }

    public void setUsuarioNovelaList(List<UsuarioNovela> usuarioNovelaList) {
        this.usuarioNovelaList = usuarioNovelaList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public Categoria getCategoriaIdFk() {
        return categoriaIdFk;
    }

    public void setCategoriaIdFk(Categoria categoriaIdFk) {
        this.categoriaIdFk = categoriaIdFk;
    }

    @XmlTransient
    public List<Capitulo> getCapituloList() {
        return capituloList;
    }

    public void setCapituloList(List<Capitulo> capituloList) {
        this.capituloList = capituloList;
    }

    @XmlTransient
    public List<Personaje> getPersonajeList() {
        return personajeList;
    }

    public void setPersonajeList(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }

    @XmlTransient
    public List<Galeria> getGaleriaList() {
        return galeriaList;
    }

    public void setGaleriaList(List<Galeria> galeriaList) {
        this.galeriaList = galeriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (novelaId != null ? novelaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novela)) {
            return false;
        }
        Novela other = (Novela) object;
        if ((this.novelaId == null && other.novelaId != null) || (this.novelaId != null && !this.novelaId.equals(other.novelaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pallol.novela.entities.Novela[ novelaId=" + novelaId + " ]";
    }
    
}
