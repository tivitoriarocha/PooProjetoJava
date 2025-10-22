package sistema;

import entidades.Prefeito;
import entidades.Vereador;
import entidades.Voto;
import interfaces.Candidato;
import java.util.ArrayList;
import java.util.List;

public class UrnaEletronica{

    private List<Candidato> candidatosRegistrados;
    private List<Voto> votosComputados;

    public UrnaEletronica() {
        this.candidatosRegistrados = new ArrayList<>();
        this.votosComputados = new ArrayList<>();
    }

    public void registrarCandidato(Candidato novoCandidato) {
        // Verifica se o número do candidato já existe
        for (Candidato candidato : candidatosRegistrados) {
            if (candidato.getNumeroCandidato() == novoCandidato.getNumeroCandidato()) {
                System.out.println("Erro: Candidato com número " + novoCandidato.getNumeroCandidato() + " já está registrado!");
                return;
            }
        }

        // Se não encontrou duplicata, registra o candidato
        candidatosRegistrados.add(novoCandidato);
        System.out.println("Candidato " + novoCandidato.getNumeroCandidato() + " registrado com sucesso!");
    }

    public void receberVoto(Voto voto) {
        int numeroVotado = voto.getNumeroCandidatoVotado();
        Candidato candidatoEncontrado = null;

        // Procura o candidato pelo número votado
        for (Candidato candidato : candidatosRegistrados) {
            if (candidato.getNumeroCandidato() == numeroVotado) {
                candidatoEncontrado = candidato;
                break;
            }
        }

        if (candidatoEncontrado != null) {
            // Se encontrou o candidato, registra o voto
            candidatoEncontrado.receberVoto();
            votosComputados.add(voto);
            System.out.println("Voto para o número " + numeroVotado + " confirmado!");
        } else {
            System.out.println("Voto nulo (candidato " + numeroVotado + " não encontrado).");
        }
    }

    // Métodos fornecidos prontos (conforme mencionado no passo a passo)
    public void exibirResultados() {
        System.out.println("\n=== resultados da eleição ===".toUpperCase());
        for (Candidato candidato : candidatosRegistrados) {
            candidato.exibirDadosCandidato();
            System.out.println("Total de votos: " + candidato.getTotalVotos());
            System.out.println("---------------------------");
        }

        // Exibir total de votos nulos (quando não encontrou candidato)
        long votosNulos = votosComputados.stream()
                .filter(voto -> {
                    for (Candidato c : candidatosRegistrados) {
                        if (c.getNumeroCandidato() == voto.getNumeroCandidatoVotado()) {
                            return false;
                        }
                    }
                    return true;
                })
                .count();
        System.out.println("Total de votos nulos: " + votosNulos);
    }

    public List<Candidato> getCandidatosRegistrados() {
        return this.candidatosRegistrados;
    }

    public void exibirGanhadores() {
        System.out.println("\n=== GANHADORES DA ELEIÇÃO ===");

        // Encontrar prefeito(s) com mais votos
        Candidato prefeitoGanhador = null;
        List<Candidato> prefeitosEmpatados = new ArrayList<>();
        int maxVotosPrefeito = 0;

        // Percorrer todos os candidatos para encontrar prefeitos
        for (Candidato candidato : candidatosRegistrados) {
            if (candidato instanceof Prefeito) {
                int votos = candidato.getTotalVotos();

                if (votos > maxVotosPrefeito) {
                    // Encontrou um com mais votos
                    maxVotosPrefeito = votos;
                    prefeitoGanhador = candidato;
                    prefeitosEmpatados.clear();
                    prefeitosEmpatados.add(candidato);
                } else if (votos == maxVotosPrefeito && votos > 0) {
                    // Encontrou um empate
                    prefeitosEmpatados.add(candidato);
                }
            }
        }

        // Mostrar resultado para prefeitos
        if (maxVotosPrefeito > 0) {
            if (prefeitosEmpatados.size() == 1) {
                System.out.println("PREFEITO ELEITO:");
                prefeitoGanhador.exibirDadosCandidato();
                System.out.println("Votos: " + maxVotosPrefeito);
            } else {
                System.out.println("EMPATE PARA PREFEITO:");
                for (Candidato prefeito : prefeitosEmpatados) {
                    prefeito.exibirDadosCandidato();
                    System.out.println("Votos: " + maxVotosPrefeito);
                    System.out.println("---");
                }
            }
        } else {
            System.out.println("Nenhum prefeito recebeu votos.");
        }

        // Encontrar vereador(es) com mais votos
        Candidato vereadorGanhador = null;
        List<Candidato> vereadoresEmpatados = new ArrayList<>();
        int maxVotosVereador = 0;

        // Percorrer todos os candidatos para encontrar vereadores
        for (Candidato candidato : candidatosRegistrados) {
            if (candidato instanceof Vereador) {
                int votos = candidato.getTotalVotos();

                if (votos > maxVotosVereador) {
                    // Encontrou um com mais votos
                    maxVotosVereador = votos;
                    vereadorGanhador = candidato;
                    vereadoresEmpatados.clear();
                    vereadoresEmpatados.add(candidato);
                } else if (votos == maxVotosVereador && votos > 0) {
                    // Encontrou um empate
                    vereadoresEmpatados.add(candidato);
                }
            }
        }

        // Mostrar resultado para vereadores
        if (maxVotosVereador > 0) {
            if (vereadoresEmpatados.size() == 1) {
                System.out.println("\nVEREADOR MAIS VOTADO:");
                vereadorGanhador.exibirDadosCandidato();
                System.out.println("Votos: " + maxVotosVereador);
            } else {
                System.out.println("\nEMPATE PARA VEREADOR MAIS VOTADO:");
                for (Candidato vereador : vereadoresEmpatados) {
                    vereador.exibirDadosCandidato();
                    System.out.println("Votos: " + maxVotosVereador);
                    System.out.println("---");
                }
            }
        } else {
            System.out.println("Nenhum vereador recebeu votos.");
        }

        System.out.println("===========================\n");
    }


}
