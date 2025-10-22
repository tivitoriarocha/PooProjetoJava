package br.com.exemplo.eleicao.entidades;

public class Voto {

    private Eleitor eleitor;
    private int numeroCandidatoVotado;

    public Voto(Eleitor eleitor, int numeroCandidatoVotado) {
        this.eleitor = eleitor;
        this.numeroCandidatoVotado = numeroCandidatoVotado;
    }

    public int getNumeroCandidatoVotado() { return numeroCandidatoVotado; }

}
