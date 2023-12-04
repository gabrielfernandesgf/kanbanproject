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
public class Empresa {
    private String nome;
    private List<Projeto> projetos;
    private List<Area> areas;

    public Empresa() {
        this.projetos = new ArrayList<>();
        this.areas = new ArrayList<>();
    }
    
    public Projeto encontrarProjetoPorNome(String nomeProjeto){
        for(Projeto projeto : projetos){
            if(projeto.getNome().equals(nomeProjeto)){
                return projeto;
            }
        }
        return null;
    }

    public Empresa(String nome) {
        this.nome = nome;
        this.projetos = new ArrayList<>();
        this.areas = new ArrayList<>();
    }

    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
    
    public void adicionarArea(Area area) {
        areas.add(area);
    }

    public List<Area> getAreas() {
        return areas;
    }
}
