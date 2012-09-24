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
public class Passagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codPassagem;
    
    private boolean confirmacao;
    private long codCliente;
    private String destino;
    private String origem;
    private String datas;
    private String horario;
    private long codVenda;
    private long numeroAssento;
    private double preco;

    public Passagem() {
    }

    public Passagem(long codPassagem, boolean confirmacao, long codCliente, long codVenda, long numeroAssento) {
        this.codPassagem = codPassagem;
        this.confirmacao = confirmacao;
        this.codCliente = codCliente;
        this.codVenda = codVenda;
    }
 
    public Passagem(boolean confirmacao, long codCliente, String destino, String origem, String datas, String horario, long codVenda, long numeroAssento, double preco) {
        this.confirmacao = confirmacao;
        this.codCliente = codCliente;
        this.destino = destino;
        this.origem = origem;
        this.datas = datas;
        this.horario = horario;
        this.codVenda = codVenda;
        this.numeroAssento = numeroAssento;
        this.preco = preco;
    }
    
    public Passagem(boolean confirmacao, String destino, String origem, String datas, String horario, long codVenda, long numeroAssento, double preco) {
        this.confirmacao = confirmacao;
        this.destino = destino;
        this.origem = origem;
        this.datas = datas;
        this.horario = horario;
        this.codVenda = codVenda;
        this.numeroAssento = numeroAssento;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    public long getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(long numeroAssento) {
        this.numeroAssento = numeroAssento;
    }
    
    public boolean isConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(boolean confirmacao) {
        this.confirmacao = confirmacao;
    }

    public long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(long codCliente) {
        this.codCliente = codCliente;
    }

    public long getCodPassagem() {
        return codPassagem;
    }

    public void setCodPassagem(long codPassagem) {
        this.codPassagem = codPassagem;
    }

    public long getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(long codVenda) {
        this.codVenda = codVenda;
    }
    
    @Override
    public String toString() {
        return "entidades.Passagem[ id=" + codPassagem + " ]";
    }
    
}
