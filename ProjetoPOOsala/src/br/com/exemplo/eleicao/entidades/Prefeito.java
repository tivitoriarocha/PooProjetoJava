package br.com.exemplo.eleicao.entidades;

public class Prefeito extends Politico {

    public Prefeito(String nome, Partido partido, int numeroCandidato) {
        super(nome, partido, numeroCandidato);
    }

    @Override
    public String getCargo() {
        return "Prefeito";
    }

}
