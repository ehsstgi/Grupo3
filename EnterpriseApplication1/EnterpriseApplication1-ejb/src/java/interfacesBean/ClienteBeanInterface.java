/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesBean;

import entidades.Cliente;
import entidades.Rota;
import java.util.List;

/**
 *
 * @author vneiva
 */
@javax.ejb.Remote
public interface ClienteBeanInterface {
    public boolean cadastrarCliente(Cliente cliente);
    public void  excluirCliente(Cliente cliente);
    public boolean alterarCliente(Cliente clienteAlterado, long rgAntigo);
    public boolean validarCliente(long rgCliente);
    public List<Rota> consultarPassagem();
    public boolean efetuarCompraOnline(Cliente cliente, Rota rota, String numeroAssento);
    public boolean efetuarCompraGuiche(Rota rota, String numeroAssento, String codFuncionario);
    public Cliente carregarCliente(long rgCliente, long cpfCliente);
}

