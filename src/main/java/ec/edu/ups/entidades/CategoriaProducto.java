/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "CategoriaProducto")
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCategoria;
    private String nombre;
    private String descripcion;
    @Transient
    private boolean editable;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Producto> producto = new ArrayList<Producto>();

    public CategoriaProducto() {
    }

    public CategoriaProducto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
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

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public String toString() {
        String u = ",sucursalCategoria==(null)";

        String d = ", producto=(null)";
        if (this.producto != null) {
            d = ", producto=" + this.producto.toString() + ")";
        }
        return "CategoriaSucursal{" + "codigoCategoria=" + codigoCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + u + d + '}';
    }

}
