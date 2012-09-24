package beans;


/**
 *
 * @author vneiva
 */
import entidades.Rota;
import entidades.Venda;
import interfacesBean.ClienteBeanInterface;
import entidades.Cliente;
import interfacesBean.RotaBeanInterface;
import interfacesBean.VendaBeanInterface;
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

 @Stateless (mappedName="ejb/VendaBean")
public class VendaBean implements VendaBeanInterface{
     @Id
    private Long id;
    @PersistenceUnit
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU");
    private EntityManager em;


    @Override
    public boolean registrarVenda(Venda venda) {
        List< Venda > vendas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            if(vendas != null){
                em.persist(venda);
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
    public void alterarVenda(Venda venda, Venda vendaAlterada) {
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("DELETE FROM Venda v WHERE v.codVenda="+venda.getCodVenda());
            em.persist(vendaAlterada);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Venda> listar() {
        List<Venda> vendas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select v FROM Venda v");
            vendas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return vendas;
    }

    @Override
    public List<Venda> listarVendasCliente(Cliente cliente) {
        List<Venda> vendas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select v FROM Venda v WHERE v.codCliente="+cliente.getCodCliente()+"");
            vendas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return vendas;
    }
    
}
