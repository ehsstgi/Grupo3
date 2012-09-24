/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesBean;

import entidades.Cliente;
import entidades.Rota;
import entidades.Venda;
import java.util.List;

/**
 *
 * @author vneiva
 */
@javax.ejb.Remote
public interface VendaBeanInterface {
    public boolean registrarVenda(Venda venda);
    public void  alterarVenda(Venda venda, Venda vendaAlterada);
    public List <Venda> listar();
    public List <Venda> listarVendasCliente(Cliente cliente);
}

