package LocaMais;

import Model.Veiculo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LocaMaisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocaMaisApplication.class, args);

        Scanner sc = new Scanner(System.in);
    }

}
