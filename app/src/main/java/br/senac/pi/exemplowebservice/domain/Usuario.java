package br.senac.pi.exemplowebservice.domain;

/**
 * Created by Aluno on 14/12/2015.
 */
public class Usuario {
    private int id;
   
    public Usuario(){}

    public Usuario(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    private String nome;
    private int idade;
}
