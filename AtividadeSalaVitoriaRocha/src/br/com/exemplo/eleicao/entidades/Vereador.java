package entidades;

public class Vereador extends Politico{

    public Vereador(String nome, Partido partido, int numeroCandidato){
        super(nome,partido,numeroCandidato);
    }

    @Override
    public String getCargo() {
        return "Vereador";
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
