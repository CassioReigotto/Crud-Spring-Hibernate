package br.com.cassio.crudspringhibernate.entity;


public class UsuarioRequest {


    private String nome;

    private String email;

    private String senha;

    public UsuarioRequest() {

    }

    public UsuarioRequest(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public UsuarioRequest setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioRequest setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
