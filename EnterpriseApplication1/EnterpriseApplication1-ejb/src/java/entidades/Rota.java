/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author vneiva
 */
@Entity
public class Rota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codRota;
    private String origemRota;
    private String destinoRota;
    private String datas;
    private String horario;
    private String numeroAssentosOcupados;
    private int codCarro;
    private double preco;

    public Rota() {
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }   
    
    public String getNumeroAssentosOcupados() {
        return numeroAssentosOcupados;
    }

    public void setNumeroAssentosOcupados(String numeroAssentosOcupados) {
        this.numeroAssentosOcupados = numeroAssentosOcupados;
    }
    
    public int getCodCarro() {
        return codCarro;
    }

    public void setCodCarro(int codCarro) {
        this.codCarro = codCarro;
    }

    public int getCodRota() {
        return codRota;
    }

    public void setCodRota(int codRota) {
        this.codRota = codRota;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getDestinoRota() {
        return destinoRota;
    }

    public void setDestinoRota(String destinoRota) {
        this.destinoRota = destinoRota;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getOrigemRota() {
        return origemRota;
    }

    public void setOrigemRota(String origemRota) {
        this.origemRota = origemRota;
    }


    @Override
    public String toString() {
        return "entidades.Rota[ id=" + codRota + " ]";
    }
    
}
