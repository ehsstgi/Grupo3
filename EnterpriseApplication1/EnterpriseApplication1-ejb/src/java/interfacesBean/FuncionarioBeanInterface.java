/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesBean;

import entidades.Funcionario;
import java.util.List;

/**
 *
 * @author vneiva
 */
@javax.ejb.Remote
public interface FuncionarioBeanInterface {
    public boolean cadastrarFuncionario(Funcionario funcionario);
    public void  excluirFuncionario(Funcionario funcionario);
    public List <Funcionario> listarFuncionarios();
}

