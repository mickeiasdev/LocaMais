package Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Locacao {
    Veiculo veiculo;
    Cliente cliente;
    double valor;
    int tempo;
    LocalDateTime dataRetirada;
    LocalDateTime dataDevolucaoPrevista;
    LocalDateTime dataDevolucao;

    Scanner input = new Scanner(System.in);

    Locacao(Veiculo veiculo, Cliente cliente) {
        setVeiculo(veiculo);
        setCliente(cliente);
    }

    public void iniciarLocacao(int tempo) {
        Veiculo veiculo = getVeiculo();
        if (veiculo.alugar()) {
            setDataRetirada(LocalDateTime.now());
            setDataDevolucaoPrevista(LocalDateTime.now().plusDays(tempo));
            setTempo(tempo);
            System.out.println("Locacao iniciado com sucesso! Veículo alugado por " + tempo + "dias.");
        } else {
            System.out.println("O veículo se encontra indisponível!  Status: " + veiculo.getStatus());
        }

    }

    public boolean finalizarLocacao() {
        setDataDevolucao(LocalDateTime.now());
        System.out.print("Locacao finalizada! O veículo necessita de manutenção [S/N]: ");
        Veiculo veiculo = getVeiculo();
        if (input.nextLine().equalsIgnoreCase("S")) {
            veiculo.verificarDefeito(true);
            return true;
        } else if (input.nextLine().equalsIgnoreCase("N")) {
            veiculo.verificarDefeito(false);
            if (getDataDevolucaoPrevista().isBefore(LocalDateTime.now())) {
                long horasAtraso = ChronoUnit.HOURS.between(getDataDevolucaoPrevista(), getDataDevolucao());
                setValor(veiculo.getValorDiaria() * (Math.ceil(horasAtraso / 24.0) + getTempo()));
            } else setValor(veiculo.getValorDiaria() * (double) getTempo());
            return true;
        }
        return false;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDateTime getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}