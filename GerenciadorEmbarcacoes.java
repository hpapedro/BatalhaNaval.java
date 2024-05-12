package Marcha;

import java.util.ArrayList;
import java.util.Random;

public class GerenciadorEmbarcacoes {
    private ArrayList<Embarcacao> embarcacoes;

    public GerenciadorEmbarcacoes() {
        this.embarcacoes = new ArrayList<>();
        inicializarEmbarcacoes();
    }

    private void inicializarEmbarcacoes() {
        embarcacoes.add(new PortaAvioes());
        embarcacoes.add(new PortaAvioes());
        embarcacoes.add(new Destroyer());
        embarcacoes.add(new Destroyer());
        embarcacoes.add(new Destroyer());
        embarcacoes.add(new Submarino());
        embarcacoes.add(new Submarino());
        embarcacoes.add(new Submarino());
        embarcacoes.add(new Submarino());
        embarcacoes.add(new Fragata());
        embarcacoes.add(new Fragata());
        embarcacoes.add(new Fragata());
        embarcacoes.add(new Fragata());
        embarcacoes.add(new Bote());
        embarcacoes.add(new Bote());
        embarcacoes.add(new Bote());
        embarcacoes.add(new Bote());
        embarcacoes.add(new Bote());
        embarcacoes.add(new Bote());
    }

    public ArrayList<Embarcacao> getEmbarcacoes() {
        return embarcacoes;
    }

    // Método para posicionar embarcações no mapa de forma aleatória
    public void posicionarEmbarcacoes(Mapa mapa) {
        Random random = new Random();
        char[][] matriz = mapa.getMatriz();
        int tamanho = matriz.length; // Obtém o tamanho da matriz

        for (Embarcacao embarcacao : embarcacoes) {
            boolean posicaoValida = false;
            while (!posicaoValida) {
                int linha = random.nextInt(tamanho);
                int coluna = random.nextInt(tamanho);
                boolean vertical = random.nextBoolean();

                // Verifica se a posição é válida para a embarcação
                posicaoValida = verificarPosicao(matriz, linha, coluna, vertical, embarcacao);
                if (posicaoValida) {
                    // Se a posição for válida, insere a embarcação no mapa
                    inserirEmbarcacao(matriz, linha, coluna, vertical, embarcacao);
                }
            }
        }

        // Atualiza a matriz do mapa após posicionar as embarcações
        mapa.setMatriz(matriz);
    }

    private boolean verificarPosicao(char[][] matriz, int linha, int coluna, boolean vertical, Embarcacao embarcacao) {
        int tamanho = embarcacao.getTamanho(); // Corrigido: estava faltando o método getTamanho()
        if (vertical) {
            if (linha + tamanho > matriz.length) {
                return false;
            }
            for (int i = linha; i < linha + tamanho; i++) {
                if (matriz[i][coluna] != 'V') {
                    return false;
                }
            }
        } else {
            if (coluna + tamanho > matriz.length) {
                return false;
            }
            for (int j = coluna; j < coluna + tamanho; j++) {
                if (matriz[linha][j] != 'V') {
                    return false;
                }
            }
        }
        return true;
    }

    private void inserirEmbarcacao(char[][] matriz, int linha, int coluna, boolean vertical, Embarcacao embarcacao) {
        int tamanho = embarcacao.getTamanho(); // Corrigido: estava faltando o método getTamanho()
        if (vertical) {
            for (int i = linha; i < linha + tamanho; i++) {
                matriz[i][coluna] = embarcacao.getTipo();
            }
        } else {
            for (int j = coluna; j < coluna + tamanho; j++) {
                matriz[linha][j] = embarcacao.getTipo();
            }
        }
    }
}
