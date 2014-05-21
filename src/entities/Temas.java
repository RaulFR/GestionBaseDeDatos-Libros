/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raul
 */
@Entity
@Table(name = "temas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temas.findAll", query = "SELECT t FROM Temas t"),
    @NamedQuery(name = "Temas.findByIdTema", query = "SELECT t FROM Temas t WHERE t.idTema = :idTema"),
    @NamedQuery(name = "Temas.findByTema", query = "SELECT t FROM Temas t WHERE t.tema = :tema")})
public class Temas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTema")
    private Integer idTema;
    @Column(name = "Tema")
    private String tema;
    @OneToMany(mappedBy = "idTema")
    private Collection<Libros> librosCollection;

    public Temas() {
    }

    public Temas(Integer idTema) {
        this.idTema = idTema;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @XmlTransient
    public Collection<Libros> getLibrosCollection() {
        return librosCollection;
    }

    public void setLibrosCollection(Collection<Libros> librosCollection) {
        this.librosCollection = librosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTema != null ? idTema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temas)) {
            return false;
        }
        Temas other = (Temas) object;
        if ((this.idTema == null && other.idTema != null) || (this.idTema != null && !this.idTema.equals(other.idTema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Temas[ idTema=" + idTema + " ]";
    }
    
}
