package LocaMais;

import Model.Veiculo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Scanner;

@SpringBootApplication
public class LocaMaisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocaMaisApplication.class, args);

        Scanner input = new Scanner(System.in);
        Veiculo[] veiculos = new Veiculo[10];
        int quantidadeVeiculos = 0;

        int opcao = 0;
        do {
            System.out.println("\n---------------------------------------------------------------------------");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Listar Veículos Disponíveis");
            System.out.println("3. Alugar um Veículo");
            System.out.println("4. Devolver um Veículo");
            System.out.println("9. Sair");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("\nDigite a opcao desejada: ");

            switch (opcao = input.nextInt()) {
                case 1:
                    int quantidadeCadastro = 1;
                    System.out.print("Digite a quantidade de veículos a ser cadastrado: ");
                    if (input.hasNextInt()) {
                        quantidadeCadastro = input.nextInt();
                        input.nextLine();
                        if (quantidadeCadastro < 1) {
                            System.out.println("Você digitou um valor inválido! Quantidade padrão \"1\".");
                            quantidadeCadastro = 1;
                        }
                    } else {
                        System.out.println("Você digitou um valor inválido! Quantidade padrão \"1\".");
                    }

                    for (int i = 0; i < quantidadeCadastro; i++) {
                        System.out.println("Digite os informações necessárias de cadastro.");

                        System.out.print("Tipo: ");
                        String tipo = input.nextLine();
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();
                        System.out.print("Ano: ");
                        int ano = input.nextInt();
                        input.nextLine();
                        System.out.print("Placa: ");
                        String placa = input.nextLine();
                        System.out.print("Diaria: ");
                        double valorDiaria = input.nextDouble();
                        input.nextLine();
                        int id = quantidadeVeiculos + 1;

                        Veiculo veiculo = new Veiculo(id, tipo, marca, modelo, ano, placa, valorDiaria);
                        veiculos[quantidadeVeiculos] = veiculo;
                        quantidadeVeiculos++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < quantidadeVeiculos; i++) {
                        Veiculo veiculo = veiculos[i];
                        if (veiculo.getStatus() == Veiculo.StatusVeiculo.DISPONIVEL) {
                            veiculo.exibirInfo();
                        }
                    }
                    break;
                default:
                    System.out.println("Erro! Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 9);
    }

}
