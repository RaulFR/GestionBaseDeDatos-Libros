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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "editoriales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editoriales.findAll", query = "SELECT e FROM Editoriales e"),
    @NamedQuery(name = "Editoriales.findByIdEditorial", query = "SELECT e FROM Editoriales e WHERE e.idEditorial = :idEditorial"),
    @NamedQuery(name = "Editoriales.findByNombre", query = "SELECT e FROM Editoriales e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Editoriales.findByDireccion", query = "SELECT e FROM Editoriales e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Editoriales.findByPoblacion", query = "SELECT e FROM Editoriales e WHERE e.poblacion = :poblacion"),
    @NamedQuery(name = "Editoriales.findByCodPostal", query = "SELECT e FROM Editoriales e WHERE e.codPostal = :codPostal"),
    @NamedQuery(name = "Editoriales.findByNif", query = "SELECT e FROM Editoriales e WHERE e.nif = :nif"),
    @NamedQuery(name = "Editoriales.findByTelefono", query = "SELECT e FROM Editoriales e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Editoriales.findByFax", query = "SELECT e FROM Editoriales e WHERE e.fax = :fax"),
    @NamedQuery(name = "Editoriales.findByEmail", query = "SELECT e FROM Editoriales e WHERE e.email = :email"),
    @NamedQuery(name = "Editoriales.findByWeb", query = "SELECT e FROM Editoriales e WHERE e.web = :web"),
    @NamedQuery(name = "Editoriales.findByNombreContacto", query = "SELECT e FROM Editoriales e WHERE e.nombreContacto = :nombreContacto")})
public class Editoriales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEditorial")
    private Integer idEditorial;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Poblacion")
    private String poblacion;
    @Column(name = "CodPostal")
    private String codPostal;
    @Column(name = "Nif")
    private String nif;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Fax")
    private String fax;
    @Column(name = "Email")
    private String email;
    @Column(name = "Web")
    private String web;
    @Column(name = "NombreContacto")
    private String nombreContacto;
    @OneToMany(mappedBy = "idEditorial")
    private Collection<Libros> librosCollection;
    @JoinColumn(name = "IdProvincia", referencedColumnName = "IdProvincia")
    @ManyToOne
    private Provincias idProvincia;

    public Editoriales() {
    }

    public Editoriales(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    @XmlTransient
    public Collection<Libros> getLibrosCollection() {
        return librosCollection;
    }

    public void setLibrosCollection(Collection<Libros> librosCollection) {
        this.librosCollection = librosCollection;
    }

    public Provincias getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Provincias idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditorial != null ? idEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editoriales)) {
            return false;
        }
        Editoriales other = (Editoriales) object;
        if ((this.idEditorial == null && other.idEditorial != null) || (this.idEditorial != null && !this.idEditorial.equals(other.idEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Editoriales[ idEditorial=" + idEditorial + " ]";
    }
    
}
