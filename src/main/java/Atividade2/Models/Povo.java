package Atividade2.Models;

public class Povo {
    private int id;
    private String nome;
    private String origem;
    private int quantidade;

    public Povo(String nome, String origem, int quantidade) {
        this.nome = nome;
        this.origem = origem;
        this.quantidade = quantidade;
    }

    // getters
    public String getNome() { return nome; }
    public String getOrigem() { return origem; }
    public int getQuantidade() { return quantidade; }
}
