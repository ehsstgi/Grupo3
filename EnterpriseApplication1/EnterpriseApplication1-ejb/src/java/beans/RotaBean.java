package beans;


/**
 *
 * @author vneiva
 */
import entidades.Rota;
import interfacesBean.BeanInterface;
import entidades.Cliente;
import interfacesBean.RotaBeanInterface;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

 @Stateless (mappedName="ejb/RotaBean")
public class RotaBean implements RotaBeanInterface{
     @Id
    private Long id;
    @PersistenceUnit
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU");
    private EntityManager em;

    @Override
    public List < Rota > alterarCarro(int carro, int codRota) {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("UPDATE TABLE ROTA r SET carro='"+carro+"' WHERE codRota ="+codRota+"");
            rotas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return rotas;
    }

    @Override
    public List < Rota > alterarDestino(String destino, int codRota) {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("UPDATE TABLE ROTA r SET destinoRota='"+destino+"' WHERE codRota ="+codRota+"");
            rotas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return rotas;
    }

    @Override
    public boolean alterarHorario(String horario, String novoHorario, String origem, String destino, String data) {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT r FROM Rota r WHERE r.origemRota='"+origem+"' and r.destinoRota='"+destino+"' and r.horario='"+horario+"' and r.datas='"+data+"' ");
            rotas = query.getResultList();
            Rota rota = rotas.get(0);
            rota.setHorario(novoHorario);
            
            if(!rotas.isEmpty()){
                em.merge(rota);
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
    public List < Rota > alterarOrigem(String origem, int codRota) {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("UPDATE TABLE ROTA r SET origemRota='"+origem+"' WHERE codRota ='"+codRota+"'");
            rotas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return rotas;
    }

    @Override
    public void escolherPoltrona(String poltrona, Rota rota) {
         List< String > assentos = null;
         String assentosOcupados [] = null;
         String atualizaAssentos="";
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT r.numeroAssentosOcupados FROM Rota r WHERE r.origemRota='"+rota.getOrigemRota()+"' and r.destinoRota='"+rota.getDestinoRota()+"' and r.horario='"+rota.getHorario()+"' and r.datas='"+rota.getDatas()+"' ");
            assentos = query.getResultList();
            assentosOcupados = assentos.get(0).split(",");
            for(int i=0;i<assentosOcupados.length; i++){
                if(i==0)
                    atualizaAssentos = assentosOcupados[i];
                else
                    atualizaAssentos = atualizaAssentos+","+assentosOcupados[i];
            }
            if(atualizaAssentos.isEmpty())
                atualizaAssentos = poltrona;
            else
                atualizaAssentos = atualizaAssentos+","+poltrona;
            
            rota.setNumeroAssentosOcupados(atualizaAssentos);

            em.merge(rota);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        
    }

    @Override
    public List<Rota> listar() {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("Select r from Rota r");
            rotas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return rotas;
    }

    @Override
    public List<Rota> listar(String origem, String destino) {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT r FROM Rota r WHERE r.origemRota='"+origem+"' and r.destinoRota='"+destino+"'");
            rotas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return rotas;
    }

    @Override
    public Rota carregarRota(String origem, String destino, String horario, String data) {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT r FROM Rota r WHERE r.origemRota='"+origem+"' and r.destinoRota='"+destino+"' and r.horario='"+horario+"' and r.datas='"+data+"' ");
            rotas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return rotas.get(0);
    }

    @Override
    public String[] assentosOcupados(String origem, String destino, String horario, String data) {
         List< String > result = null;
         List< String > assentos = null;
         String assentosOcupados [] = null;
         
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT r.numeroAssentosOcupados FROM Rota r WHERE r.origemRota='"+origem+"' and r.destinoRota='"+destino+"' and r.horario='"+horario+"' and r.datas='"+data+"' ");
            assentos = query.getResultList();
            assentosOcupados = assentos.get(0).split(",");       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return assentosOcupados;
    }
   
    
     @Override
    public boolean cadastrarRota(Rota rota) {
        List< Rota > rotas = null;
        try {
            Context ctx = new InitialContext();
            ctx = new InitialContext();
            em = factory.createEntityManager();
            Query query = em.createQuery("SELECT r FROM Rota r WHERE r.origemRota='"+rota.getOrigemRota()+"' "
                    + "and r.destinoRota='"+rota.getDestinoRota()+"' and r.horario='"+rota.getHorario()+"'");
            rotas = query.getResultList();
            
            if(rotas.isEmpty()){
                em.persist(rota);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }
    
    
}
