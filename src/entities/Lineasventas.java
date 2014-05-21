/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raul
 */
@Entity
@Table(name = "lineasventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineasventas.findAll", query = "SELECT l FROM Lineasventas l"),
    @NamedQuery(name = "Lineasventas.findByIdLineaVenta", query = "SELECT l FROM Lineasventas l WHERE l.idLineaVenta = :idLineaVenta"),
    @NamedQuery(name = "Lineasventas.findByNumeroLinea", query = "SELECT l FROM Lineasventas l WHERE l.numeroLinea = :numeroLinea"),
    @NamedQuery(name = "Lineasventas.findByIva", query = "SELECT l FROM Lineasventas l WHERE l.iva = :iva"),
    @NamedQuery(name = "Lineasventas.findByCantidad", query = "SELECT l FROM Lineasventas l WHERE l.cantidad = :cantidad"),
    @NamedQuery(name = "Lineasventas.findByPvpSinIva", query = "SELECT l FROM Lineasventas l WHERE l.pvpSinIva = :pvpSinIva"),
    @NamedQuery(name = "Lineasventas.findByImporte", query = "SELECT l FROM Lineasventas l WHERE l.importe = :importe")})
public class Lineasventas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdLineaVenta")
    private Integer idLineaVenta;
    @Basic(optional = false)
    @Column(name = "NumeroLinea")
    private int numeroLinea;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Iva")
    private BigDecimal iva;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "PvpSinIva")
    private BigDecimal pvpSinIva;
    @Basic(optional = false)
    @Column(name = "Importe")
    private BigDecimal importe;
    @JoinColumn(name = "IdLibro", referencedColumnName = "IdLibro")
    @ManyToOne
    private Libros idLibro;
    @JoinColumn(name = "IdVenta", referencedColumnName = "IdVenta")
    @ManyToOne(optional = false)
    private Ventas idVenta;

    public Lineasventas() {
    }

    public Lineasventas(Integer idLineaVenta) {
        this.idLineaVenta = idLineaVenta;
    }

    public Lineasventas(Integer idLineaVenta, int numeroLinea, BigDecimal iva, int cantidad, BigDecimal pvpSinIva, BigDecimal importe) {
        this.idLineaVenta = idLineaVenta;
        this.numeroLinea = numeroLinea;
        this.iva = iva;
        this.cantidad = cantidad;
        this.pvpSinIva = pvpSinIva;
        this.importe = importe;
    }

    public Integer getIdLineaVenta() {
        return idLineaVenta;
    }

    public void setIdLineaVenta(Integer idLineaVenta) {
        this.idLineaVenta = idLineaVenta;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPvpSinIva() {
        return pvpSinIva;
    }

    public void setPvpSinIva(BigDecimal pvpSinIva) {
        this.pvpSinIva = pvpSinIva;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Libros getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libros idLibro) {
        this.idLibro = idLibro;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaVenta != null ? idLineaVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineasventas)) {
            return false;
        }
        Lineasventas other = (Lineasventas) object;
        if ((this.idLineaVenta == null && other.idLineaVenta != null) || (this.idLineaVenta != null && !this.idLineaVenta.equals(other.idLineaVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lineasventas[ idLineaVenta=" + idLineaVenta + " ]";
    }
    
}
