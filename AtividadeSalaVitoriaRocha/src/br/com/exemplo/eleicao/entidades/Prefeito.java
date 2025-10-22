package entidades;

public class Prefeito extends Politico {

    public Prefeito(String nome, Partido partido, int numeroCandidato){
        super(nome,partido,numeroCandidato);
    }

    @Override
    public String getCargo() {
        return "Prefeito";
    }

    @Override
    public int numeroCandidato() {
        return numeroCandidato;
    }

    @Override
    public int totalVotos() {
        return totalVotos;
    }
}
