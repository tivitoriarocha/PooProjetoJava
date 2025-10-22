package br.com.exemplo.eleicao.sistema;

import br.com.exemplo.eleicao.entidades.Voto;
import br.com.exemplo.eleicao.interfaces.Candidato;
import java.util.ArrayList;
import java.util.List;

public class UrnaEletronica {

    private List<Candidato> candidatosRegistrados;
    private List<Voto> votosComputados;

    public UrnaEletronica() {
        this.candidatosRegistrados = new ArrayList<>();
        this.votosComputados = new ArrayList<>();
    }

    public void registrarCandidato(Candidato novoCandidato) {
        for (Candidato c : candidatosRegistrados) {
            if (c.getNumeroCandidato() == novoCandidato.getNumeroCandidato()) {
                System.out.println("Erro: número de candidato já registrado!");
                return;
            }
        }
        candidatosRegistrados.add(novoCandidato);
        System.out.println("Candidato registrado com sucesso!");
    }

    public void receberVoto(Voto voto) {
        int numeroVotado = voto.getNumeroCandidatoVotado();
        Candidato candidatoEncontrado = null;

        for (Candidato c : candidatosRegistrados) {
            if (c.getNumeroCandidato() == numeroVotado) {
                candidatoEncontrado = c;
                break;
            }
        }

        if (candidatoEncontrado != null) {
            candidatoEncontrado.receberVoto();
            votosComputados.add(voto);
            System.out.println("Voto para o número " + numeroVotado + " confirmado!");
        } else {
            System.out.println("Voto nulo (candidato " + numeroVotado + " não encontrado).");
        }
    }

    public void exibirResultados() {
        System.out.println("\n===== resultados da eleição =====".toUpperCase());
        for (Candidato c : candidatosRegistrados) {
            c.exibirDadosCandidato();
            System.out.println("Total de votos: " + c.getTotalVotos());
            System.out.println("----------------------------------");
        }
    }

    public List<Candidato> getCandidatosRegistrados() {
        return this.candidatosRegistrados;
    }

    public void exibirGanhadores() {
        if (candidatosRegistrados.isEmpty()) {
            System.out.println("Nenhum candidato registrado.");
            return;
        }

        int maiorVotoPrefeito = 0;
        for (Candidato c : candidatosRegistrados) {
            if (c instanceof br.com.exemplo.eleicao.entidades.Prefeito && c.getTotalVotos() > maiorVotoPrefeito) {
                maiorVotoPrefeito = c.getTotalVotos();
            }
        }

        System.out.println("\n===== resultado final - prefeitos =====".toUpperCase());
        System.out.println("Maior número de votos: " + maiorVotoPrefeito);

        int contPrefeitos = 0;
        for (Candidato c : candidatosRegistrados) {
            if (c instanceof br.com.exemplo.eleicao.entidades.Prefeito && c.getTotalVotos() == maiorVotoPrefeito) {
                contPrefeitos++;
                c.exibirDadosCandidato();
                System.out.println("Total de votos: " + c.getTotalVotos());
                System.out.println("----------------------------------");
            }
        }
        if (contPrefeitos > 1) {
            System.out.println("Empate entre " + contPrefeitos + " candidatos a Prefeito!");
        } else if (contPrefeitos == 1) {
            System.out.println("Temos um vencedor único para Prefeito!");
        } else {
            System.out.println("Nenhum voto para Prefeitos.");
        }

        int maiorVotoVereador = 0;
        for (Candidato c : candidatosRegistrados) {
            if (c instanceof br.com.exemplo.eleicao.entidades.Vereador && c.getTotalVotos() > maiorVotoVereador) {
                maiorVotoVereador = c.getTotalVotos();
            }
        }

        System.out.println("\n===== resultado final - vereadores =====".toUpperCase());
        System.out.println("Maior número de votos: " + maiorVotoVereador);

        int contVereadores = 0;
        for (Candidato c : candidatosRegistrados) {
            if (c instanceof br.com.exemplo.eleicao.entidades.Vereador && c.getTotalVotos() == maiorVotoVereador) {
                contVereadores++;
                c.exibirDadosCandidato();
                System.out.println("Total de votos: " + c.getTotalVotos());
                System.out.println("----------------------------------");
            }
        }
        if (contVereadores > 1) {
            System.out.println("Empate entre " + contVereadores + " candidatos a Vereador!");
        } else if (contVereadores == 1) {
            System.out.println("Temos um vencedor único para Vereador!");
        } else {
            System.out.println("Nenhum voto para Vereadores.");
        }
    }



}
