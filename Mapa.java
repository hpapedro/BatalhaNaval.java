package Marcha;

import java.util.Random;

public class Mapa {
    private char[][] matriz;
    private int tamanho;

    // Construtor para inicializar o mapa com espaços vazios
    public Mapa(int tamanho) {
        this.tamanho = tamanho;
        this.matriz = new char[tamanho][tamanho];
        inicializarMapa();
    }

    // Método para inicializar o mapa com espaços vazios (70% de espaços vazios)
    private void inicializarMapa() {
        Random random = new Random();
        int totalEspacos = tamanho * tamanho;
        int espacosVazios = (int) (totalEspacos * 0.7);

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = 'O'; // Inicialmente, todos os espaços estão ocultos
            }
        }

        // Preencher espaços vazios
        while (espacosVazios > 0) {
            int linha = random.nextInt(tamanho);
            int coluna = random.nextInt(tamanho);
            if (matriz[linha][coluna] == 'O') {
                matriz[linha][coluna] = 'V'; // V para espaços vazios
                espacosVazios--;
            }
        }
    }

    // Método para exibir o mapa
    public void exibirMapa() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Métodos para acessar e modificar a matriz
    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    // Método para realizar um ataque no mapa
    public boolean atirar(int linha, int coluna) {
        if (matriz[linha][coluna] != 'V') {
            return false; // Se não houver navio na posição, retorna false (água)
        } else {
            matriz[linha][coluna] = 'X'; // Se houver navio na posição, marca como atingido
            return true; // Retorna true (acerto)
        }
    }

    // Método para verificar se todos os navios foram afundados
    public boolean todosAfundados() {
        // TODO: Implementar lógica de verificação
        return false;
    }
}
