/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Acao {
    private String nomeAcao;
    private Date dataInicio;
    private Date dataTermino;
    private String areaResponsavel;
    private String usuarioResponsavel;
    private int progresso; // Em percentagem de 0 a 100
    private StatusAcao status;
    private List<Usuario> usuarios;

    public Acao(String nomeAcao, Date dataInicio, Date dataTermino, String areaResponsavel, String usuarioResponsavel) {
        this.nomeAcao = nomeAcao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.areaResponsavel = areaResponsavel;
        this.usuarioResponsavel = usuarioResponsavel;
        this.progresso = 0;
        this.status = StatusAcao.NAO_INICIADA; // Inicializa como A FAZER
        this.usuarios = new ArrayList<>();
    }
    
    public void concluirAcao(int percentual) {
        if (percentual >= 0 && percentual <= 100) {
            this.progresso = percentual;
            verificarDataFim();
            atualizarStatus(); // Atualiza o status ao concluir a ação
        } else {
            System.out.println("Percentual inválido. Deve estar entre 0 e 100.");
        }
    }
    
     private void verificarDataFim() {
        if (new Date().after(dataTermino) && progresso < 100) {
            System.out.println("Aviso: Ação '" + nomeAcao + "' não foi concluída até a data fim.");
        }
    }
     
     private void atualizarStatus() {
        if (progresso == 0) {
            status = StatusAcao.NAO_INICIADA;
        } else if (progresso > 0 && progresso < 100) {
            status = StatusAcao.EM_ANDAMENTO;
        } else {
            status = StatusAcao.CONCLUIDA;
        }
    }
     
     public int progresso() {
        return progresso;
    }

    public String getNome() {
        return nomeAcao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataTermino;
    }

    public StatusAcao getStatus() {
        return status;
    }

    public String getAreaResponsavel() {
        return areaResponsavel;
    }

    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }
    
    // Método para adicionar usuário associado à ação
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Métodos getter para a lista de usuários
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public String toString() {
        return "Ação: " + nomeAcao + "\nPercentual concluído: " + progresso + "%" +
                "\nData de início: " + dataInicio + "\nData Fim: " + dataTermino + "\nStatus: " + status;
    }
    
    
    
    
}
