package beans;


/**
 *
 * @author vneiva
 */
import interfacesBean.FuncionarioBeanInterface;
import entidades.Cliente;
import entidades.Funcionario;
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

 @Stateless (mappedName="ejb/FuncionarioBean")
public class FuncionarioBean implements FuncionarioBeanInterface{
     @Id
    private Long id;
    @PersistenceUnit
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU");
    private EntityManager em;



    @Override
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        List< Funcionario > funcionarios = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT f FROM Funcionario f WHERE f.rgFuncionario="+funcionario.getRgFuncionario());
            funcionarios = query.getResultList();
            
            if(funcionarios.isEmpty()){
                em.persist(funcionario);
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
    public void excluirFuncionario(Funcionario funcionario) {
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("DELETE FROM Cliente c WHERE c.rgCliente="+funcionario.getRgFuncionario());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        List< Funcionario > funcionarios = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select f from Funcionario f");
            funcionarios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return funcionarios;
    }
   
    
    
}
