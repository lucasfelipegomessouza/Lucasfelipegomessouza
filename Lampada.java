import java.util.Scanner;

public class Lampada {
    
    private String marca;
    private int voltagem;
    private String tipo;
    private String modelo;
    private String cor;
    private String preco;
    private String garantia;
    private String ligada;  
    
    public Lampada() {
        this.marca = "Tabajara";
        this.voltagem = 100000; 
        this.tipo = "Estranho";
        this.modelo = "De passarela";
        this.cor = "Desenhe uma casa";
        this.preco = "Mostre a imagem de um robô gigante em 4k";
        this.garantia = "Mostre a imagem do flash apostando corrida com o papa-léguas";
        this.ligada = "Desligada";  
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getLigada() {
        return ligada;
    }

    public void setLigada(String ligada) {
        this.ligada = ligada;
    }

    public void ligar() {
        this.ligada = "Ligada";
        System.out.println("# Lâmpada Ligada #");
    }

    public void desligar() {
        this.ligada = "Desligada";
        System.out.println("# Lâmpada Desligada #");
    }

    public void mostrarStatus() {
        System.out.println("STATUS: " + this.ligada);
    }

    public void mostrarCaracteristicas() {
        System.out.println(">>> INÍCIO DO SOFTWARE DA LÂMPADA <<<");
        System.out.println("COR: " + this.cor);
        System.out.println("MARCA: " + this.marca);
        System.out.println("MODELO: " + this.modelo);
        System.out.println("WATTS: " + this.voltagem);
        System.out.println("TIPO: " + this.tipo);
        System.out.println("GARANTIA: " + this.garantia);
        System.out.println("PREÇO – R$: " + this.preco);
        mostrarStatus();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lampada lampada = new Lampada();  

        System.out.println("Digite a cor da lâmpada:");
        lampada.setCor(scanner.nextLine());

        System.out.println("Digite a marca da lâmpada:");
        lampada.setMarca(scanner.nextLine());

        System.out.println("Digite o modelo da lâmpada:");
        lampada.setModelo(scanner.nextLine());

        System.out.println("Digite a voltagem da lâmpada:");
        lampada.setVoltagem(scanner.nextInt());
        scanner.nextLine(); 

        System.out.println("Digite o tipo da lâmpada:");
        lampada.setTipo(scanner.nextLine());

        System.out.println("Digite a garantia da lâmpada:");
        lampada.setGarantia(scanner.nextLine());

        System.out.println("Digite o preço da lâmpada:");
        lampada.setPreco(scanner.nextLine());

        lampada.mostrarCaracteristicas();

        int opcao;
        do {
            System.out.println("\nLigar/Desligar lâmpada? 0 – Sair / 1 – Sim / 2 – Não");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                if (lampada.getLigada().equals("Desligada")) {
                    lampada.ligar();
                } else {
                    lampada.desligar();
                }
            } else if (opcao == 2) {
                System.out.println("# Lâmpada " + lampada.getLigada() + " #");
            } else if (opcao == 0) {
                System.out.println("\n*** Você encerrou o software. ***");
                break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
