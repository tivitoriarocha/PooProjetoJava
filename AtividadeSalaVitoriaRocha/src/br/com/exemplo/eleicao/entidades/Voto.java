package entidades;

public class Voto {

    protected Eleitor eleitor;
    protected int numeroCandidatoVotado;

    public Voto(Eleitor eleitor, int numeroCandidatoVotado){
        this.eleitor = eleitor;
        this.numeroCandidatoVotado = numeroCandidatoVotado;
    }

    public int getNumeroCandidatoVotado() {
        return numeroCandidatoVotado;
    }
}
