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


public class Projeto {
    private String nome;
    private String descricao;
    private List<Atividades> atividades;
    private List<Area> areas;
    private Date dataInicio;
    private Date dataFim;

    public Projeto() {
        this.atividades = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    public Projeto(String nomeProjeto, String descricao, Date dataInicio, Date dataFim) {
        this.nome = nomeProjeto;
        this.descricao = descricao;
        this.atividades = new ArrayList<>();
        this.areas = new ArrayList<>();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void adicionarAtividade(Atividades atividade) {
        atividades.add(atividade);
    }
    
    public List<Atividades> getAtividades() {
        return atividades;
    }
    
    public void adicionarArea(Area area) {
        areas.add(area);
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataFim() {
        return dataFim;
    }
    
    public Atividades encontrarAtividadePorNome(String nomeAtividade) {
        for (Atividades atividade : atividades) {
            if (atividade.getDescricao().equals(nomeAtividade)) {
                return atividade;
            }
        }
        return null; // Retorna null se a atividade não for encontrada
    }
    
    public int getPercentualProjeto(){
        if(atividades.isEmpty()){
            return 0; 
        }
        int percentual = 0;
        
        for(Atividades atividade : atividades){
            percentual += atividade.getPercentualConcluidoAtividade();
        }
        return percentual / atividades.size();
    }

    @Override
    public String toString() {
        return "Projeto: " + nome + "\nDescrição: " + descricao + "\nPercentual total do Projeto: " + getPercentualProjeto();
    }
    
}
