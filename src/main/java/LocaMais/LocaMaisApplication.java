package LocaMais;

import Model.Cliente;
import Model.Locacao;
import Model.Veiculo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LocaMaisApplication {

    public static Cliente cadastrarNovoCliente(Scanner input) {
        System.out.println("Digite o nome do cliente: ");
        String nome = input.nextLine();

        System.out.println("Digite a CNH do cliente [123456789]: ");
        String cnh = input.nextLine();

        Cliente cliente = new Cliente(nome, cnh);

        return cliente;
    }

    public static Cliente buscarClientePorCnh(Scanner input, List<Cliente> clientes) {
        System.out.println("Digite a CNH do cliente [123456789]: ");
        String cnh = input.nextLine();

        Cliente validarCliente = null;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCnh().equals(cnh)) {
                validarCliente = clientes.get(i);
                break;
            }
        }
        return validarCliente;
    }

    public static void main(String[] args) {
        SpringApplication.run(LocaMaisApplication.class, args);

        Scanner input = new Scanner(System.in);

        List<Veiculo> veiculos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Locacao> locacoesAtivas = new ArrayList<>();

        int opcao = 0;
        do {
            System.out.println("\n---------------------------------------------------------------------------");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Listar Veículos Disponíveis");
            System.out.println("3. Simular Orçamento");
            System.out.println("4. Alugar Veículo");
            System.out.println("5. Devolver um Veículo");
            System.out.println("9. Sair");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("\nDigite a opcao desejada: ");

            try {
                opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {
                    case 1:
                        int quantidadeCadastro = 1;
                        System.out.print("\nDigite a quantidade de veículos a ser cadastrado: ");
                        if (input.hasNextInt()) {
                            quantidadeCadastro = input.nextInt();
                            input.nextLine();
                            if (quantidadeCadastro < 1) {
                                System.out.println("\nVocê digitou um valor inválido! Quantidade padrão \"1\".");
                                quantidadeCadastro = 1;
                            }
                        } else {
                            System.out.println("\nVocê digitou um valor inválido! Quantidade padrão \"1\".");
                        }
                        for (int i = 0; i < quantidadeCadastro; i++) {
                            System.out.println("\nDigite os informações necessárias de cadastro.");
                            System.out.print("Tipo: ");
                            String tipo = input.nextLine();
                            System.out.print("Marca: ");
                            String marca = input.nextLine();
                            System.out.print("Modelo: ");
                            String modelo = input.nextLine();
                            boolean anoValido = false;
                            int ano = 0;
                            do {
                                System.out.print("Ano: ");
                                if (input.hasNextInt()) {
                                    ano = input.nextInt();
                                    input.nextLine();
                                    if (ano < 1950 || ano > LocalDate.now().getYear()) {
                                        System.out.println("O ano deve ser entre 1950 e " + LocalDate.now().getYear() + "!");
                                        break;
                                    }
                                    anoValido = true;
                                } else {
                                    System.out.println("Numero inválido. Tente novamente!");
                                    input.nextLine();
                                }
                            } while (!anoValido);
                            System.out.print("Placa: ");
                            String placa = input.nextLine();
                            boolean valorDiariaValida = false;
                            double valorDiaria = 0;
                            do {
                                System.out.print("Diaria: ");
                                if (input.hasNextDouble()) {
                                    valorDiaria = input.nextDouble();
                                    input.nextLine();
                                    if (valorDiaria <= 0) {
                                        System.out.println("\nO valor da diária deve ser maior que zero!");
                                        break;
                                    }
                                    valorDiariaValida = true;
                                } else {
                                    System.out.println("\nNumero inválido. Tente novamente!");
                                    input.nextLine();
                                }
                            } while (!valorDiariaValida);
                            Veiculo veiculo = new Veiculo(tipo, marca, modelo, ano, placa, valorDiaria);
                            veiculos.add(veiculo);
                        }
                        break;

                    case 2:
                        if (veiculos.size() == 0) {
                            System.out.println("\nNão há veículos cadastrados.");
                            break;
                        }
                        for (int i = 0; i < veiculos.size(); i++) {
                            Veiculo veiculo = veiculos.get(i);
                            if (veiculo.getStatus() == Veiculo.StatusVeiculo.DISPONIVEL) {
                                System.out.println();
                                System.out.println(veiculo);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("\nInforme o numero de acesso do veículo: ");
                        int acesso = input.nextInt();
                        input.nextLine();
                        boolean acessoValido = false;
                        for (int i = 0; i < veiculos.size(); i++) {
                            if (acesso == veiculos.get(i).getId()) {
                                acessoValido = true;
                                int dias = 0;
                                boolean diasValido = false;
                                do {
                                    System.out.print("\nInforme o numero de dias de locação: ");
                                    if (input.hasNextInt()) {
                                        dias = input.nextInt();
                                        input.nextLine();
                                        if (dias < 0) {
                                            System.out.println("\nA quantidade de dias deve ser maior que zero!");
                                            break;
                                        }
                                        diasValido = true;
                                    } else {
                                        System.out.println("\nNumero inválido. Tente novamente!");
                                        input.nextLine();
                                    }
                                } while (!diasValido);
                                double valor = veiculos.get(i).getValorDiaria() * dias;
                                System.out.println();
                                System.out.println(veiculos.get(i).toString());
                                System.out.println("\n>> Valor da simulação: " + valor + "R$ <<");
                                break;
                            }
                        }
                        if (!acessoValido) {
                            System.out.println("\nVeículo com Acesso \"" + acesso + "\" não encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("\nInforme o numero de acesso do veículo: ");
                        int acesso = input.nextInt();
                        input.nextLine();
                        boolean acessoValido = false;
                        for (int i = 0; i < veiculos.size(); i++) {
                            if (acesso == veiculos.get(i).getId()) {
                                acessoValido = true;
                                int dias = 0;
                                boolean diasValido = false;
                                do {
                                    System.out.print("\nInforme o numero de dias de locação: ");
                                    if (input.hasNextInt()) {
                                        dias = input.nextInt();
                                        input.nextLine();
                                        if (dias < 0) {
                                            System.out.println("\nA quantidade de dias deve ser maior que zero!");
                                            break;
                                        }
                                        diasValido = true;
                                    } else {
                                        System.out.println("\nNumero inválido. Tente novamente!");
                                        input.nextLine();
                                    }
                                } while (!diasValido);

                                Cliente cliente = buscarClientePorCnh(input, clientes);
                                if (cliente != null) {
                                    Locacao locacao = new Locacao(veiculos.get(i), cliente);
                                    if (locacao.iniciarLocacao(dias)) {
                                        locacoesAtivas.add(locacao);
                                    }
                                    break;
                                }
                                Cliente novoCliente = cadastrarNovoCliente(input);
                                System.out.println();
                                clientes.add(novoCliente);
                                Locacao locacao = new Locacao(veiculos.get(i), novoCliente);
                                if (locacao.iniciarLocacao(dias)) {
                                    locacoesAtivas.add(locacao);
                                }
                                break;
                            }
                        }
                        if (!acessoValido) {
                            System.out.println("\nVeículo com Acesso \"" + acesso + "\" não encontrado.");
                        }
                        break;
                        //refatorar o case5
                    case 5:
                        System.out.print("\nInforme o numero de acesso do veículo para devolução: ");
                        int idDevolucao = input.nextInt();
                        input.nextLine();

                        boolean validarIdDevolucao = false;

                        for (int i = 0; i < locacoesAtivas.size(); i++) {
                            if (idDevolucao == locacoesAtivas.get(i).getVeiculo().getId()) {
                                validarIdDevolucao = true;

                                if (locacoesAtivas.get(i).finalizarLocacao()) {
                                    locacoesAtivas.remove(i);
                                    break;
                                }
                            }
                        }

                        if (!validarIdDevolucao) {
                            System.out.println("\nVeículo com Acesso \"" + idDevolucao + "\" não encontrado.");
                            break;
                        }

                    case 9:
                        System.out.println("\nFinalizando...");
                        break;

                    default:
                        System.out.println("\nErro! Opção inválida. Tente novamente.");
                        break;
                }
            } catch (java.util.InputMismatchException erro) {
                System.out.println("\nERRO: " + erro + "| Por favor, digite apenas os números informados para as opções.");
                input.nextLine();
                opcao = 0;
            }
        } while (opcao != 9);
    }
}
