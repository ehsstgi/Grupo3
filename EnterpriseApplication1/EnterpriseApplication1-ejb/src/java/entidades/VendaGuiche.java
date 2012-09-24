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
public class VendaGuiche extends Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int qtdPassagem;
    private double precoTotal;
    private String funcionario;
    
    public VendaGuiche() {
    }

    public VendaGuiche(int codVenda, long codCliente, int qtdPassagem, double precoTotal) {
        super(codVenda, codCliente, qtdPassagem, precoTotal);
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
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
