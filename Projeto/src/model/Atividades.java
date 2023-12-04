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

public class Atividades {
    private String nomeAtividade;
    private int progresso; // Em percentagem de 0 a 100
    private List<Acao> acoes;
    private String descricao;
    private Date dataInicio;  // Modificado para Date
    private Date dataTermino; // Modificado para Date

    public Atividades() {

    }

    public Atividades(String descricao) {
        this.nomeAtividade = descricao;  // Corrigido para usar a descrição
        this.progresso = 0;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.acoes = new ArrayList<>();
    }

    public void adicionarAcao(Acao acao) {
        acoes.add(acao);
    }

    public int getPercentualConcluidoAtividade() {
        if (acoes.isEmpty()) {
            return 0;  // Se não há ações, a tarefa está automaticamente 0% concluída.
        }

        int somaPercentuais = 0;
        for (Acao acao : acoes) {
            somaPercentuais += acao.progresso();
        }

        return somaPercentuais / acoes.size();  // Média dos percentuais das ações.
    }

    public String getDescricao() {
        return descricao;
    }

    public void estaConcluida() {
        int percentual = getPercentualConcluidoAtividade();
        if (new Date().after(dataTermino) && percentual < 100) {
            System.out.println("Aviso: Atividade '" + descricao + "' não foi concluída até a data fim.");
        }
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public List<Acao> getAcoes() {
        return acoes;
    }

    public String getNome() {
        return nomeAtividade;
    }

    @Override
    public String toString() {
        return """
               Informação geral da atividade.
               Atividade: """ + nomeAtividade + "\nAções: " + acoes +
                "\nData de início da tarefa: " + dataInicio + "\nData Fim da tarefa: " + dataTermino + 
                "\nPercentual Concluído da Atividade: " + getPercentualConcluidoAtividade();
    }
}