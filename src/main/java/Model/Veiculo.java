package Model;

public class Veiculo {

    // principal
    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private String placa;

    // aluguel
    private double valorDiaria;
    private boolean disponivel;

    // construtor
    public Veiculo(int id, String tipo, String marca, String modelo, int ano, String cor, String placa, double valorDiaria) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    // interacoes
    public void alugar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("O carro " + modelo + " foi alugado com sucesso!");
        } else {
            System.out.println("O carro " + modelo + " não está disponível no momento.");
        }
    }
    public void devolver() {
        disponivel = true;
        System.out.println("O carro " + modelo + " foi devolvido e está disponível novamente.");
    }
    public void exibirInfo() {
        System.out.println("-------------------------------------------------");
        System.out.println(
                "Tipo: " + tipo + "\nModelo: " + modelo + "\nMarca: " + marca + "\nCor: " + cor + "\nPlaca: " + placa + "\nValor da diária: R$" + valorDiaria + "\nDisponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("-------------------------------------------------");
    }
}
