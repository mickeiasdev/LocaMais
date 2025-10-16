package LocaMais;

import Model.Veiculo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocaMaisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocaMaisApplication.class, args);

        Veiculo veiculo = new Veiculo();
        
        veiculo.exibirInfo();
    }

}
