package Marcha;

public class Jogador {
    private String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    // Método para adicionar pontos ao jogador
    public void adicionarPontos(int pontos) {
        pontuacao += pontos;
    }

    // Método para obter a pontuação atual do jogador
    public int getPontuacao() {
        return pontuacao;
    }

    // Método para exibir a pontuação do jogador
    public void exibirPontuacao() {
        System.out.println("Pontuação de " + nome + ": " + pontuacao);
    }
}
