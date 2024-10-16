import java.util.Scanner;

public class Imposto {
    // Variáveis de instância
    private double salarioMensal;
    private double prestacaoServico;
    private double ganhoCapital;
    private double gastosMedicos;
    private double gastosEducacionais;

    // Construtor
    public Imposto(double salarioMensal, double prestacaoServico, double ganhoCapital, double gastosMedicos, double gastosEducacionais) {
        this.salarioMensal = salarioMensal;
        this.prestacaoServico = prestacaoServico;
        this.ganhoCapital = ganhoCapital;
        this.gastosMedicos = gastosMedicos;
        this.gastosEducacionais = gastosEducacionais;
    }

    // Método para calcular o imposto
    public double calcularImposto() {
        double salarioAnual = salarioMensal * 12;
        double impostoTotal = 0;

        // Cálculo do imposto com base no salário mensal
        if (salarioMensal < 3000) {
            // Isento de imposto
            impostoTotal += 0; 
        } else if (salarioMensal >= 3000 && salarioMensal <= 5000) {
            impostoTotal += salarioAnual * 0.10; // 10% do salário anual
        } else {
            impostoTotal += salarioAnual * 0.20; // 20% do salário anual
        }

        // Cálculo do imposto sobre prestação de serviços
        if (prestacaoServico > 0) {
            impostoTotal += prestacaoServico * 0.15; // 15% da renda de prestação de serviços
        }

        // Cálculo do imposto sobre ganho de capital
        if (ganhoCapital > 0) {
            impostoTotal += ganhoCapital * 0.20; // 20% do ganho de capital
        }

        return impostoTotal;
    }

    // Método para calcular os abatimentos
    public double calcularAbatimentos(double impostoTotal) {
        double maxAbatimento = impostoTotal * 0.30; // 30% do imposto bruto
        double totalGastos = gastosMedicos + gastosEducacionais;

        if (totalGastos > maxAbatimento) {
            return maxAbatimento; // Abate até 30% do imposto
        } else {
            return totalGastos; // Abate os gastos médicos e educacionais
        }
    }

    // Método principal para leitura e testes
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura de dados do usuário
        System.out.print("Informe o salário mensal: ");
        double salarioMensal = scanner.nextDouble();

        System.out.print("Informe a renda com prestação de serviços: ");
        double prestacaoServico = scanner.nextDouble();

        System.out.print("Informe o ganho de capital: ");
        double ganhoCapital = scanner.nextDouble();

        System.out.print("Informe os gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();

        System.out.print("Informe os gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();

        // Criação do objeto Imposto
        Imposto imposto = new Imposto(salarioMensal, prestacaoServico, ganhoCapital, gastosMedicos, gastosEducacionais);
        
        // Cálculo do imposto total
        double impostoTotal = imposto.calcularImposto();
        // Cálculo dos abatimentos
        double abatimentos = imposto.calcularAbatimentos(impostoTotal);
        // Valor final após abatimentos
        double valorFinal = impostoTotal - abatimentos;

        // Exibição dos resultados
        System.out.println("Total bruto de imposto: R$ " + impostoTotal);
        System.out.println("Abatimentos: R$ " + abatimentos);
        System.out.println("Valor final do imposto devido: R$ " + valorFinal);

        // Fechando o scanner
        scanner.close();
    }
}