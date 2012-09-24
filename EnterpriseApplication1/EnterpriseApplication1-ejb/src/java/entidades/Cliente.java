/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author vneiva
 */
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codCliente;

    private String nomeCliente;
    private long rgCliente;
    private long cpfCliente;
    private long cartaoCredito;
    private String enderecoCliente;
    private long telCliente;

    public Cliente() {
    }

    public Cliente(String nomeCliente, long rgCliente, long cpfCliente, String enderecoCliente, long telCliente, long cartaoCredito) {
        this.nomeCliente = nomeCliente;
        this.rgCliente = rgCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoCliente = enderecoCliente;
        this.telCliente = telCliente;
        this.cartaoCredito = cartaoCredito;
    }

    public long getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(long cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    
    
    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public long getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(long cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public long getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(long rgCliente) {
        this.rgCliente = rgCliente;
    }

    public long getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(long telCliente) {
        this.telCliente = telCliente;
    }

   

    @Override
    public String toString() {
        return "beans.Pessoa[ id=" + getNomeCliente() + " ]";
    }
    
}
