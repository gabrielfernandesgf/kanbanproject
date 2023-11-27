/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author gabriel
 */
public class Usuario {
    private String nome;
    private String funcao;
    private Date dataDeEntrada;
    private String perfilDeUsuario;

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    

    public String getPerfilDeUsuario() {
        return perfilDeUsuario;
    }

    public void setPerfilDeUsuario(String perfilDeUsuario) {
        this.perfilDeUsuario = perfilDeUsuario;
    }
    
    

    public String getNome() {
        return nome;
    }


    public String getFuncao() {
        return funcao;
    }


    public Date getDataDeEntrada() {
        return dataDeEntrada;
    }
    
    
    
}
