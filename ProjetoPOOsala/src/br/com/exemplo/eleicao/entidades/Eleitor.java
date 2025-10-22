package br.com.exemplo.eleicao.entidades;

public class Eleitor {

    private String nome;
    // private e não protected para usar do encapsulamento
    // e proteger os dados do Eleitor

    public Eleitor(String nome) { this.nome = nome; }

    public String getNome() { return nome;}


}
