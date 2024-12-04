import java.util.Scanner;

public class Jogodavelha {
    
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        inicializaTabuleiro();

        while (true) {
            imprimeTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", insira sua jogada (linha e coluna): ");
            
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();
            
            if (verificaJogadaValida(linha, coluna)) {
                tabuleiro[linha][coluna] = jogadorAtual;
                
                if (verificaVitoria()) {
                    imprimeTabuleiro();
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    break;
                }
                
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
        
        scanner.close();
    }

    private static void inicializaTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private static void imprimeTabuleiro() {
        System.out.println("    0   1   2");
        System.out.println("  -------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j] + " |");
            }
            System.out.println();
            System.out.println("  -------------");
        }
    }
    
    private static boolean verificaJogadaValida(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ';
    }

    private static boolean verificaVitoria() {
        
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true;
            }
        }
        
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }
        
        return false;
    }
}
