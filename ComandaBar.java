import java.util.Scanner;

public class ComandaBar {
    
    private static final double VALOR_INGRESSO_HOMEM = 10.0;
    private static final double VALOR_INGRESSO_MULHER = 8.0;
    private static final double VALOR_CERVEJA = 5.0;
    private static final double VALOR_REFRIGERANTE = 3.0;
    private static final double VALOR_ESPETINHO = 7.0;
    private static final double VALOR_COUVERT = 4.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Informe o gênero do cliente (M para masculino / F para feminino): ");
        char genero = scanner.next().toUpperCase().charAt(0);

        
        double valorIngresso = (genero == 'M') ? VALOR_INGRESSO_HOMEM : VALOR_INGRESSO_MULHER;

        
        System.out.print("Informe a quantidade de cervejas consumidas: ");
        int quantidadeCervejas = scanner.nextInt();
        
        System.out.print("Informe a quantidade de refrigerantes consumidos: ");
        int quantidadeRefrigerantes = scanner.nextInt();

        System.out.print("Informe a quantidade de espetinhos consumidos: ");
        int quantidadeEspetinhos = scanner.nextInt();

        
        double consumoTotal = (quantidadeCervejas * VALOR_CERVEJA) +
                              (quantidadeRefrigerantes * VALOR_REFRIGERANTE) +
                              (quantidadeEspetinhos * VALOR_ESPETINHO);

        
        double valorCouvert = (consumoTotal > 30) ? 0 : VALOR_COUVERT;

        
        double valorFinal = valorIngresso + consumoTotal + valorCouvert;

        
        System.out.println("\n--- Relatório de Consumo ---");
        System.out.printf("Valor do ingresso: R$ %.2f%n", valorIngresso);
        System.out.printf("Consumo total: R$ %.2f%n", consumoTotal);
        if (valorCouvert > 0) {
            System.out.printf("Valor do couvert: R$ %.2f%n", valorCouvert);
        } else {
            System.out.println("Couvert isento.");
        }
        System.out.printf("Valor total a pagar: R$ %.2f%n", valorFinal);

        
        scanner.close();
    }
}