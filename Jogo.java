package Marcha;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private Mapa mapaJogador1;
    private Mapa mapaJogador2;
    private Jogador jogador1;
    private Jogador jogador2;
    private ArrayList<String> logJogador1;
    private ArrayList<String> logJogador2;
    private boolean jogoEmAndamento;

    public Jogo(String nomeJogador1, String nomeJogador2) {
        mapaJogador1 = new Mapa(10); // Tamanho do mapa pode variar
        mapaJogador2 = new Mapa(10);
        jogador1 = new Jogador(nomeJogador1);
        jogador2 = new Jogador(nomeJogador2);
        logJogador1 = new ArrayList<>();
        logJogador2 = new ArrayList<>();
        jogoEmAndamento = true;
    }

    // Métodos getters para os mapas dos jogadores
    public Mapa getMapaJogador1() {
        return mapaJogador1;
    }

    public Mapa getMapaJogador2() {
        return mapaJogador2;
    }

    // Método para iniciar o jogo
    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);

        // Loop principal do jogo
        while (jogoEmAndamento) {
            // Jogador 1 faz um ataque
            System.out.println("Jogador 1, é a sua vez de atacar!");
            System.out.println("Mapa do Jogador 2:");
            mapaJogador2.exibirMapa();
            System.out.println("Escolha uma linha para atacar: ");
            int linha1 = scanner.nextInt();
            System.out.println("Escolha uma coluna para atacar: ");
            int coluna1 = scanner.nextInt();
            boolean acertouJogador2 = mapaJogador2.atirar(linha1, coluna1);
            if (acertouJogador2) {
                System.out.println("Acertou um navio do Jogador 2!");
                jogador1.adicionarPontos(1);
            } else {
                System.out.println("Água! Nenhum navio atingido.");
            }

            // Verifica se o Jogador 1 venceu
            if (mapaJogador2.todosAfundados()) {
                System.out.println("Jogador 1 venceu!");
                break;
            }

            // Jogador 2 faz um ataque
            System.out.println("Jogador 2, é a sua vez de atacar!");
            System.out.println("Mapa do Jogador 1:");
            mapaJogador1.exibirMapa();
            System.out.println("Escolha uma linha para atacar: ");
            int linha2 = scanner.nextInt();
            System.out.println("Escolha uma coluna para atacar: ");
            int coluna2 = scanner.nextInt();
            boolean acertouJogador1 = mapaJogador1.atirar(linha2, coluna2);
            if (acertouJogador1) {
                System.out.println("Acertou um navio do Jogador 1!");
                jogador2.adicionarPontos(1);
            } else {
                System.out.println("Água! Nenhum navio atingido.");
            }

            // Verifica se o Jogador 2 venceu
            if (mapaJogador1.todosAfundados()) {
                System.out.println("Jogador 2 venceu!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo("Jogador1", "Jogador2");
        jogo.iniciarJogo();
    }
}
