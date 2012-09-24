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
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codFunc;
    
    private String nomeFuncionario;
    private long rgFuncionario;

    public Funcionario() {
    }

    public Funcionario(String nomeFuncionario, long rgFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.rgFuncionario = rgFuncionario;
    }

    
    public Long getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(Long codFunc) {
        this.codFunc = codFunc;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public long getRgFuncionario() {
        return rgFuncionario;
    }

    public void setRgFuncionario(long rgFuncionario) {
        this.rgFuncionario = rgFuncionario;
    }
    
    
    @Override
    public String toString() {
        return "entidades.Funcionario[ id=" + codFunc + " ]";
    }
    
}
