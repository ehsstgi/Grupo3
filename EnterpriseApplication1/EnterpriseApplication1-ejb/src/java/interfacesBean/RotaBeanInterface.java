/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesBean;

import entidades.Rota;
import java.util.List;

/**
 *
 * @author vneiva
 */
@javax.ejb.Remote
public interface RotaBeanInterface {
    public List < Rota > listar();
    public Rota carregarRota(String origem, String destino, String horario, String data);
    public List < Rota > listar(String origem, String destino);
    public void escolherPoltrona(String poltrona, Rota rota);
    public String[] assentosOcupados(String origem, String destino, String horario, String data);
    public boolean alterarHorario(String horario, String novoHorario, String origem, String destino, String data);
    public List < Rota > alterarOrigem(String origem, int codRota);
    public List < Rota > alterarDestino(String destino, int codRota);
    public List < Rota > alterarCarro(int carro, int codRota);
    public boolean cadastrarRota(Rota rota);
}

