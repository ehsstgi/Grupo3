package beans;


/**
 *
 * @author vneiva
 */
import entidades.Rota;
import interfacesBean.ClienteBeanInterface;
import entidades.Cliente;
import entidades.Passagem;
import entidades.Venda;
import entidades.VendaGuiche;
import entidades.VendaOnline;
import interfacesBean.RotaBeanInterface;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

 @Stateless (mappedName="ejb/ClienteBean")
public class ClienteBean implements ClienteBeanInterface{
     @Id
    private Long id;
    @PersistenceUnit
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU");
    private EntityManager em;

    public List<Cliente> listarClientes() {
        List< Cliente > clientes = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select c from Cliente c");
            clientes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return clientes;
    }


    @Override
    public boolean cadastrarCliente(Cliente cliente) {
        List< Cliente > clientes = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.rgCliente="+cliente.getRgCliente());
            clientes = query.getResultList();
            
            if(clientes.isEmpty()){
                em.persist(cliente);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public void excluirCliente(Cliente cliente) {
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("DELETE FROM Cliente c WHERE c.rgCliente="+cliente.getRgCliente());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean alterarCliente(Cliente clienteAlterado, long rgAntigo) {
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            List< String > clientes = null;
            
            Cliente cliente = null;
            ClienteBeanInterface bean = (ClienteBeanInterface)ctx.lookup("ejb/ClienteBean");
            cliente = bean.carregarCliente(rgAntigo,0);
            
            em = factory.createEntityManager();
           // Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.rgCliente="+cliente.getRgCliente()+", c.cpfCliente="+cliente.getCpfCliente());
            //clientes = query.getResultList();
            
            cliente.setCartaoCredito(clienteAlterado.getCartaoCredito());
            cliente.setCpfCliente(clienteAlterado.getCpfCliente());
            cliente.setEnderecoCliente(clienteAlterado.getEnderecoCliente());
            cliente.setNomeCliente(clienteAlterado.getNomeCliente());
            cliente.setRgCliente(clienteAlterado.getRgCliente());
            cliente.setTelCliente(clienteAlterado.getTelCliente());
            
            em.merge(cliente);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean validarCliente(long rg) {
        List< Cliente > clientes = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.rgCliente="+rg);
            clientes = query.getResultList();
            
            if(!clientes.isEmpty()){
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public List<Rota> consultarPassagem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean efetuarCompraOnline(Cliente cliente, Rota rota, String numeroAssento) {
        List< Cliente > clientes = null;
        
        VendaOnline venda = new VendaOnline();
        venda.setCodCliente(cliente.getCodCliente());
        venda.setCodRota(rota.getCodRota());
        venda.setQtdPassagem(1);
        venda.setPrecoTotal(rota.getPreco());
        venda.setNumeroAssento(Long.parseLong(numeroAssento));
        Passagem passagem = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            em.persist(venda);
            long codVenda = venda.getCodVenda();
            
            passagem = new Passagem(true, cliente.getCodCliente(), rota.getDestinoRota(), rota.getOrigemRota(), rota.getDatas(), rota.getHorario(), venda.getCodVenda(), Long.parseLong(numeroAssento), rota.getPreco());
            em.persist(passagem);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return true;
    }
    
    @Override
    public boolean efetuarCompraGuiche(Rota rota, String numeroAssento, String codFuncionario) {
        List< Cliente > clientes = null;
        
        VendaGuiche venda = new VendaGuiche();
        venda.setCodRota(rota.getCodRota());
        venda.setQtdPassagem(1);
        venda.setPrecoTotal(rota.getPreco());
        venda.setNumeroAssento(Long.parseLong(numeroAssento));
        venda.setFuncionario(codFuncionario);
        Passagem passagem = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            em.persist(venda);
            long codVenda = venda.getCodVenda();
            
            passagem = new Passagem(true, rota.getDestinoRota(), rota.getOrigemRota(), rota.getDatas(), rota.getHorario(), venda.getCodVenda(), Long.parseLong(numeroAssento), rota.getPreco());
            em.persist(passagem);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public Cliente carregarCliente(long rg, long cpf) {
         List< Cliente > clientes = null;
         Cliente cliente = null;         
         try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = null;
            
            if(rg!=0)
                query = em.createQuery("SELECT c FROM Cliente c WHERE c.rgCliente="+rg);
            else if(cpf!=0)
                query = em.createQuery("SELECT c FROM Cliente c WHERE c.cpfCliente="+cpf);
            
            clientes = query.getResultList();
            
            if(clientes.isEmpty()){
                cliente = new Cliente();
                return cliente;
            }else{
                return clientes.get(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return cliente;
    }
   
    
    
}
