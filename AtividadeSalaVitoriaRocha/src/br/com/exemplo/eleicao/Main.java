
import entidades.*;
import sistema.UrnaEletronica;

public class Main {
    public static void main(String[] args) {

        // 1. Criar a Urna
        UrnaEletronica urna = new UrnaEletronica();

        // 2. Criar os Partidos
        Partido partidoDemocrata = new Partido("Partido Democrático", "PD");
        Partido partidoSocial = new Partido("Partido Social", "PS");
        Partido partidoTrabalhista = new Partido("Partido Trabalhista", "PT");

        // 3. Criar os candidatos (Prefeitos e Vereadores)
        Prefeito prefeito1 = new Prefeito("João Silva", partidoDemocrata, 12);
        Prefeito prefeito2 = new Prefeito("Maria Santos", partidoSocial, 15);

        Vereador vereador1 = new Vereador("Carlos Oliveira", partidoDemocrata, 12345);
        Vereador vereador2 = new Vereador("Ana Costa", partidoSocial, 15151);
        Vereador vereador3 = new Vereador("Pedro Alves", partidoTrabalhista, 20202);
        Vereador vereador4 = new Vereador("Julia Mendes", partidoDemocrata, 12121);

        // 4. Registrar os candidatos na urna
        urna.registrarCandidato(prefeito1);
        urna.registrarCandidato(prefeito2);
        urna.registrarCandidato(vereador1);
        urna.registrarCandidato(vereador2);
        urna.registrarCandidato(vereador3);
        urna.registrarCandidato(vereador4);

        // 5. Criar os eleitores
        Eleitor eleitor1 = new Eleitor("Pedro Rocha");
        Eleitor eleitor2 = new Eleitor("Antonio Padua");
        Eleitor eleitor3 = new Eleitor("Graciana Maria");
        Eleitor eleitor4 = new Eleitor("Sofia Palmeira");
        Eleitor eleitor5 = new Eleitor("Duda Mel");
        Eleitor eleitor6 = new Eleitor("Pedro Filho");

        // 6. Simular a votação
        System.out.println(("\n== iniciando votação ==").toUpperCase());

        // Votos válidos
        urna.receberVoto(new Voto(eleitor1, 12));  // Prefeito 1
        urna.receberVoto(new Voto(eleitor2, 15));  // Prefeito 2
        urna.receberVoto(new Voto(eleitor3, 12));  // Prefeito 1
        urna.receberVoto(new Voto(eleitor4, 15));  // Prefeito 2

        // Votos para vereadores
        urna.receberVoto(new Voto(eleitor1, 12345)); // Vereador 1
        urna.receberVoto(new Voto(eleitor2, 15151)); // Vereador 2
        urna.receberVoto(new Voto(eleitor3, 12345)); // Vereador 1
        urna.receberVoto(new Voto(eleitor4, 20202)); // Vereador 3
        urna.receberVoto(new Voto(eleitor5, 12121)); // Vereador 4
        urna.receberVoto(new Voto(eleitor6, 15151)); // Vereador 2

        // Votos nulos (candidatos inexistentes)
        urna.receberVoto(new Voto(eleitor5, 99999)); // Número inexistente
        urna.receberVoto(new Voto(eleitor6, 11111)); // Número inexistente

        // 7. Apurar e exibir os resultados
        System.out.println("\n== apuração dos votos ==".toUpperCase());
        urna.exibirResultados();

        urna.exibirGanhadores();

    }
}