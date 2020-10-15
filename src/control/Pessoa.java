/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Timestamp;
import java.util.Date;
import lib.Entity;

/**
 *
 * @author Cristiano Peiter <cristiano.peiter@universo.univates.br>
 */

public class Pessoa extends Entity
{
    private String   nome;
    private String   cpf;
    private String   login;
    private String   senha;
    private String   endereco;
    private String   telefone;
    private String   email;
    private Date     nascimento;
    private String   genero;
    private Timestamp dt_cadastro;
    private int      ativo;
    private int      ref_cidade;
    private int      ref_nivel_acesso;

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Timestamp getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Timestamp dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int getRef_cidade() {
        return ref_cidade;
    }

    public void setRef_cidade(int ref_cidade) {
        this.ref_cidade = ref_cidade;
    }

    public int getRef_nivel_acesso() {
        return ref_nivel_acesso;
    }

    public void setRef_nivel_acesso(int ref_nivel_acesso) {
        this.ref_nivel_acesso = ref_nivel_acesso;
    }
    
    @Override
    public String toString()
    {
        return this.nome;
    }
}
