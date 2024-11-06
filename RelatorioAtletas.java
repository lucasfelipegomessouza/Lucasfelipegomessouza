import java.util.Scanner;

public class RelatorioAtletas {

    // Função para ler o sexo com validação
    public static String lerSexo(Scanner scanner) {
        String sexo;
        while (true) {
            System.out.print("Sexo (M/F): ");
            sexo = scanner.nextLine().toUpperCase();
            if (sexo.equals("M") || sexo.equals("F")) {
                break;
            } else {
                System.out.println("Valor inválido! Favor digitar F ou M.");
            }
        }
        return sexo;
    }

    // Função para ler altura com validação de valor positivo
    public static double lerAltura(Scanner scanner) {
        double altura;
        while (true) {
            System.out.print("Altura (em metros): ");
            altura = scanner.nextDouble();
            if (altura > 0) {
                break;
            } else {
                System.out.println("Valor inválido! Favor digitar um valor positivo.");
            }
        }
        return altura;
    }

    // Função para ler peso com validação de valor positivo
    public static double lerPeso(Scanner scanner) {
        double peso;
        while (true) {
            System.out.print("Peso (em kg): ");
            peso = scanner.nextDouble();
            if (peso > 0) {
                break;
            } else {
                System.out.println("Valor inválido! Favor digitar um valor positivo.");
            }
        }
        return peso;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da quantidade de atletas
        System.out.print("Qual a quantidade de atletas? ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consome o caractere de nova linha

        // Variáveis para armazenar dados
        String atletaMaisAlto = "";
        double alturaMax = 0;
        double somaPesos = 0;
        double alturaMulheres = 0;
        int homens = 0;
        int mulheres = 0;

        // Leitura dos dados dos atletas
        for (int i = 1; i <= N; i++) {
            System.out.println("Digite os dados do atleta numero " + i + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            String sexo = lerSexo(scanner);
            double altura = lerAltura(scanner);
            double peso = lerPeso(scanner);

            // Acumulando as informações
            somaPesos += peso;
            if (sexo.equals("M")) {
                homens++;
            } else {
                mulheres++;
                alturaMulheres += altura;
            }

            // Verificando o atleta mais alto
            if (altura > alturaMax) {
                alturaMax = altura;
                atletaMaisAlto = nome;
            }
        }

        // Calculando as estatísticas
        double pesoMedio = somaPesos / N;
        double porcentagemHomens = (homens * 100.0) / N;

        // Imprimindo o relatório
        System.out.println("### RELATÓRIO ###");
        System.out.printf("Peso médio dos atletas: %.2f\n", pesoMedio);
        System.out.println("Atleta mais alto: " + atletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f %%\n", porcentagemHomens);

        if (mulheres > 0) {
            double alturaMediaMulheres = alturaMulheres / mulheres;
            System.out.printf("Altura média das mulheres: %.2f\n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas.");
        }

        scanner.close();
    }
}
