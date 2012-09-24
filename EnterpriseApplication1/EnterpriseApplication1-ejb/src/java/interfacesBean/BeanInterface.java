/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesBean;

import entidades.Cliente;
import java.util.List;

/**
 *
 * @author vneiva
 */
@javax.ejb.Remote
public interface BeanInterface {
    public boolean verificarMaioridade(String nome, String dataNascimento);
    public List < Cliente > listar();
}
