/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author vneiva
 */
@Entity
public class VendaOnline extends Venda implements Serializable {
   
    private int qtdPassagem;
    private double precoTotal;
    
    public VendaOnline() {
    }

    public VendaOnline(int codVenda, long codCliente, int qtdPassagem, double precoTotal) {
        super(codVenda, codCliente, qtdPassagem, precoTotal);
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getQtdPassagem() {
        return qtdPassagem;
    }

    public void setQtdPassagem(int qtdPassagem) {
        this.qtdPassagem = qtdPassagem;
    }
    
    
}
