package br.com.exemplo.eleicao;

import br.com.exemplo.eleicao.entidades.*;
import br.com.exemplo.eleicao.sistema.UrnaEletronica;

public class Main {
    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica();

        Partido p1 = new Partido("Partido Democrata", "PD");
        Partido p2 = new Partido("Partido Socialista", "PS");

        Prefeito prefeito1 = new Prefeito("Mariana Almeida", p1, 10);
        Prefeito prefeito2 = new Prefeito("Josiene", p2, 20);
        Vereador vereador1 = new Vereador("Leninha", p1, 101);
        Vereador vereador2 = new Vereador("Grabriela Prioli", p2, 202);

        urna.registrarCandidato(prefeito1);
        urna.registrarCandidato(prefeito2);
        urna.registrarCandidato(vereador1);
        urna.registrarCandidato(vereador2);

        Eleitor e1 = new Eleitor("Pedro Rocha");
        Eleitor e2 = new Eleitor("Betânio");
        Eleitor e3 = new Eleitor("Antônio Moreira");

        urna.receberVoto(new Voto(e1, 202));
        urna.receberVoto(new Voto(e2, 101));
        urna.receberVoto(new Voto(e3, 10));

        urna.exibirResultados();
        urna.exibirGanhadores();
    }
}
