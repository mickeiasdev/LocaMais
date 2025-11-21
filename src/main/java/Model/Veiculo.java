package Model;

import java.util.UUID;

public class Veiculo {

    public enum StatusVeiculo {
        DISPONIVEL,
        ALUGADO,
        EM_MANUTENCAO
    }

    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private StatusVeiculo status = StatusVeiculo.DISPONIVEL;

    private double valorDiaria;

    public Veiculo(int id, String tipo, String marca, String modelo, int ano, String placa, double valorDiaria) {
        setId(id);
        setTipo(tipo);
        setMarca(marca);
        setModelo(modelo);
        setAno(ano);
        setPlaca(placa);
        setValorDiaria(valorDiaria);
        setStatus(StatusVeiculo.DISPONIVEL);
    }

    public boolean alugar() {
        if (getStatus() == StatusVeiculo.DISPONIVEL) {
            setStatus(StatusVeiculo.ALUGADO);
            return true;
        }
        return false;
    }

    public void verificarDefeito(boolean status) {
        if (status) fazerRevisao();
        else devolver();
    }

    private void fazerRevisao() {
        setStatus(StatusVeiculo.EM_MANUTENCAO);
        System.out.println("Veículo enviado para manutenção!  Status: " + getStatus());
    }

    public void devolver() {
        setStatus(StatusVeiculo.DISPONIVEL);
        System.out.println("Veículo devolvido com sucesso! Status: " + getStatus());
    }

    public void exibirInfo() {
        System.out.println(
                "Acesso: " + getId() +"\nTipo: " + getTipo() + "\nModelo: " + getModelo() + "\nMarca: " + getMarca() + "\nPlaca: " + getPlaca() + "\nValor da diária: R$" + getValorDiaria());
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}