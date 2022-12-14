/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author johan
 */
@Entity
@Table(name="Cuenta")
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCuenta;
    
    private String correo;
    private String contrasena;
    
    @Transient
    private boolean editable;

    @OneToOne
    @JoinColumn
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<TarjetaCredito> tarjetaC = new ArrayList<TarjetaCredito>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaPedido")
    private List<Pedido> pedido = new ArrayList<Pedido>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaFactura")
    private List<Factura> factura = new ArrayList<Factura>();

    public Cuenta() {
        this("","",null);
    }

    public Cuenta(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Cuenta(String correo, String contrasena, Usuario usuario) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public List<TarjetaCredito> getTarjetaC() {
        return tarjetaC;
    }

    public void setTarjetaC(List<TarjetaCredito> tarjetaC) {
        this.tarjetaC = tarjetaC;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }


    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }

    

    @Override
    public String toString() {
        String u = ",usuario=(null)";
        if(this.usuario != null){
            u=",UsuarioId=("+this.usuario.getCedula()+")";
        }
        return "Cuenta{" + "correo=" + correo + ", contrasena=" + contrasena +u+
               ", tarjetaC=" + tarjetaC + ", pedido=" + pedido + '}';
    }

   

}
