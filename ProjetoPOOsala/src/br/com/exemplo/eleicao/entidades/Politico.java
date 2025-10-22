package br.com.exemplo.eleicao.entidades;

import br.com.exemplo.eleicao.interfaces.Candidato;

public abstract class Politico implements Candidato {

    protected String nome;
    protected Partido partido;
    protected int numeroCandidato;
    protected int totalVotos;

    public Politico (String nome, Partido partido, int numeroCandidato){
        this.nome = nome;
        this.partido = partido;
        this.numeroCandidato = numeroCandidato;
        this.totalVotos = 0;
    }

    @Override
    public int getNumeroCandidato(){
        return this.numeroCandidato;
    }

    @Override
    public void receberVoto() {
        this.totalVotos++;
    }

    @Override
    public int getTotalVotos() {
        return this.totalVotos;
    }

    @Override
    public void exibirDadosCandidato() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Partido: " + this.partido.getNome() + " (" + this.partido.getSigla() + ")");
        System.out.println("Número: " + this.numeroCandidato);
        System.out.println("Cargo: " + getCargo());
    }

    public abstract String getCargo();

}
