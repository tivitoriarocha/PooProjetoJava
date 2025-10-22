package entidades;

public class Partido {

    protected String nome, sigla;

    public Partido(String nome, String sigla){

        this.nome = nome;
        this.sigla = sigla;

    }

    public String getNomePartido(){
        return nome;
    }
    public String getSigla(){
        return sigla;
    }

}
