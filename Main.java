package Marcha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação do jogo com dois jogadores
        Jogo jogo = new Jogo("Jogador1", "Jogador2");

        // Inicia o jogo
        jogo.iniciarJogo();

        // Pergunta se deseja jogar novamente
        System.out.println("Deseja jogar novamente? (s/n)");
        String jogarNovamente = scanner.nextLine();

        // Enquanto o jogador quiser jogar novamente, inicia um novo jogo
        while (jogarNovamente.equalsIgnoreCase("s")) {
            jogo = new Jogo("Jogador1", "Jogador2");
            jogo.iniciarJogo();
            System.out.println("Deseja jogar novamente? (s/n)");
            jogarNovamente = scanner.nextLine();
        }

        // Fim do programa
        System.out.println("Fim do jogo. Obrigado por jogar!");
        scanner.close();
    }
}
