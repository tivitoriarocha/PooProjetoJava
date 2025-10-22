package entidades;

import interfaces.Candidato;

public abstract class Politico implements Candidato{

    protected String nome;
    protected Partido partido;
    protected int numeroCandidato, totalVotos;

    public Politico(String nome, Partido partido, int numeroCandidato){
        this.nome = nome;
        this.partido = partido;
        this.numeroCandidato = numeroCandidato;
        totalVotos = 0;
    }

    @Override
    public int getNumeroCandidato() { return this.numeroCandidato; }

    @Override
    public void receberVoto() {
        this.totalVotos++;
    }

    @Override
    public int getTotalVotos() { return this.totalVotos; }

    @Override
    public void exibirDadosCandidato() {
        System.out.println(" == informações do Candidato == ".toUpperCase());
        System.out.println("Nome: " + this.nome);
        System.out.println("Partido: " + this.partido.getNomePartido() + " - " + this.partido.getSigla());
        System.out.println("Número: " + this.numeroCandidato);
        System.out.println("Cargo: " + getCargo());
    }

    public abstract String getCargo();

}
