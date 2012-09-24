/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesBean;

import entidades.Cliente;
import entidades.Passagem;
import java.util.List;

/**
 *
 * @author vneiva
 */
@javax.ejb.Remote
public interface PassagemBeanInterface {
    public List <Passagem> listarPassagensCliente(Cliente cliente);
    public List <Passagem> gerarHistorico();
    public Passagem listarPassagemVendaCliente(Cliente cliente, long codVenda);
    public Passagem listarPassagemGuiche(String origem, String destino, String poltrona, String data, String horario);
}

