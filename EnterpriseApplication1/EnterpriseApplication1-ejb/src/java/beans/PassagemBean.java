package beans;


/**
 *
 * @author vneiva
 */
import entidades.Passagem;
import entidades.Rota;
import entidades.Venda;
import interfacesBean.ClienteBeanInterface;
import entidades.Cliente;
import interfacesBean.PassagemBeanInterface;
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

 @Stateless (mappedName="ejb/PassagemBean")
public class PassagemBean implements PassagemBeanInterface{
     @Id
    private Long id;
    @PersistenceUnit
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU");
    private EntityManager em;


    @Override
    public List<Passagem> listarPassagensCliente(Cliente cliente) {
        List<Passagem> passagens = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select p FROM Passagem p WHERE p.codCliente="+cliente.getCodCliente()+"");
            passagens = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return passagens;
    }

    @Override
    public Passagem listarPassagemVendaCliente(Cliente cliente, long codVenda) {
        List<Passagem> passagens = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select p FROM Passagem p WHERE p.codCliente="+cliente.getCodCliente()+" and p.codVenda='"+codVenda+"'");
            passagens = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return passagens.get(0);
    }
    
    @Override
    public List<Passagem> gerarHistorico() {
        List<Passagem> passagens = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select p FROM Passagem p");
            passagens = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return passagens;
    }

    @Override
    public Passagem listarPassagemGuiche(String origem, String destino, String poltrona, String data, String horario) {
        List<Passagem> passagens = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select p FROM Passagem p WHERE p.origem='"+origem+"' and p.destino='"+destino+"' and p.numeroAssento="+poltrona+" and p.horario='"+horario+"' and p.datas='"+data+"'");
            passagens = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return passagens.get(0);
    }
    
}
