/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raul
 */
@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findByIdLibro", query = "SELECT l FROM Libros l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libros.findByIsbn", query = "SELECT l FROM Libros l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libros.findByEan", query = "SELECT l FROM Libros l WHERE l.ean = :ean"),
    @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libros.findByAutores", query = "SELECT l FROM Libros l WHERE l.autores = :autores"),
    @NamedQuery(name = "Libros.findByPreciocoste", query = "SELECT l FROM Libros l WHERE l.preciocoste = :preciocoste"),
    @NamedQuery(name = "Libros.findByPvpsiniva", query = "SELECT l FROM Libros l WHERE l.pvpsiniva = :pvpsiniva"),
    @NamedQuery(name = "Libros.findByStockactual", query = "SELECT l FROM Libros l WHERE l.stockactual = :stockactual"),
    @NamedQuery(name = "Libros.findByStockminimo", query = "SELECT l FROM Libros l WHERE l.stockminimo = :stockminimo"),
    @NamedQuery(name = "Libros.findByStockmaximo", query = "SELECT l FROM Libros l WHERE l.stockmaximo = :stockmaximo"),
    @NamedQuery(name = "Libros.findByFechaEdicion", query = "SELECT l FROM Libros l WHERE l.fechaEdicion = :fechaEdicion")})
public class Libros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdLibro")
    private Integer idLibro;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "EAN")
    private String ean;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "AUTORES")
    private String autores;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIOCOSTE")
    private BigDecimal preciocoste;
    @Column(name = "PVPSINIVA")
    private BigDecimal pvpsiniva;
    @Column(name = "STOCKACTUAL")
    private Integer stockactual;
    @Column(name = "STOCKMINIMO")
    private Integer stockminimo;
    @Column(name = "STOCKMAXIMO")
    private Integer stockmaximo;
    @Column(name = "FechaEdicion")
    @Temporal(TemporalType.DATE)
    private Date fechaEdicion;
    @JoinColumn(name = "IdTema", referencedColumnName = "IdTema")
    @ManyToOne
    private Temas idTema;
    @JoinColumn(name = "IdEditorial", referencedColumnName = "IdEditorial")
    @ManyToOne
    private Editoriales idEditorial;
    @OneToMany(mappedBy = "idLibro")
    private Collection<Lineasventas> lineasventasCollection;

    public Libros() {
    }

    public Libros(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libros(Integer idLibro, String titulo, String autores) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autores = autores;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public BigDecimal getPreciocoste() {
        return preciocoste;
    }

    public void setPreciocoste(BigDecimal preciocoste) {
        this.preciocoste = preciocoste;
    }

    public BigDecimal getPvpsiniva() {
        return pvpsiniva;
    }

    public void setPvpsiniva(BigDecimal pvpsiniva) {
        this.pvpsiniva = pvpsiniva;
    }

    public Integer getStockactual() {
        return stockactual;
    }

    public void setStockactual(Integer stockactual) {
        this.stockactual = stockactual;
    }

    public Integer getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(Integer stockminimo) {
        this.stockminimo = stockminimo;
    }

    public Integer getStockmaximo() {
        return stockmaximo;
    }

    public void setStockmaximo(Integer stockmaximo) {
        this.stockmaximo = stockmaximo;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public Temas getIdTema() {
        return idTema;
    }

    public void setIdTema(Temas idTema) {
        this.idTema = idTema;
    }

    public Editoriales getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editoriales idEditorial) {
        this.idEditorial = idEditorial;
    }

    @XmlTransient
    public Collection<Lineasventas> getLineasventasCollection() {
        return lineasventasCollection;
    }

    public void setLineasventasCollection(Collection<Lineasventas> lineasventasCollection) {
        this.lineasventasCollection = lineasventasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Libros[ idLibro=" + idLibro + " ]";
    }
    
}
