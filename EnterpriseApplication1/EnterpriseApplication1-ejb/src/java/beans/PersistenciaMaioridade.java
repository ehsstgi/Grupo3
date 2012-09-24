/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

public class PersistenciaMaioridade {
    @Id
    private Long id;
    @PersistenceUnit
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU");
    private EntityManager em;

   

    
    public boolean gravar(Cliente pessoa){
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            //BeanInterface bean = (BeanInterface)ctx.lookup("ejb/Atividade7");

            em = factory.createEntityManager();
            //UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
           // utx.begin();
//            em.joinTransaction();
            em.persist(pessoa);
           // utx.commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    
    }
    
    public List< Cliente > listar() {
        List< Cliente > pessoa = null;
        try {
            /*Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();*/
            em = factory.createEntityManager();
            Query query = em.createQuery("Select p from Pessoa p");
            pessoa = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

