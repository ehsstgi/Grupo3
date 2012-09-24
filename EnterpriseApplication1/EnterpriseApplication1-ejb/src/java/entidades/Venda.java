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
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codVenda;
    private long codRota;
    private long codCliente;
    private long numeroAssento;

    public Venda() {
    }

    public Venda(int codVenda, long codCliente, int qtdPassagem, double precoTotal) {
        this.codVenda = codVenda;
        this.codCliente = codCliente;
    }
    
    public long getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(long numeroAssento) {
        this.numeroAssento = numeroAssento;
    }
   
    public long getCodRota() {
        return codRota;
    }

    public void setCodRota(long codRota) {
        this.codRota = codRota;
    }
    
    public long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(long codCliente) {
        this.codCliente = codCliente;
    }

    public long getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(long codVenda) {
        this.codVenda = codVenda;
    }

   
    
    @Override
    public String toString() {
        return "entidades.Venda[ id=" + codVenda + " ]";
    }
    
}
