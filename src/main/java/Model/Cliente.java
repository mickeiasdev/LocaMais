package Model;

import java.util.UUID;

public class Cliente {
    private String id;
    private String nome;
    private String cnh;

    Cliente(String nome, String cnh) {
        setId(UUID.randomUUID().toString());
        setNome(nome);
        setCnh(cnh);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
