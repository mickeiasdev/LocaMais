package Model;

import java.util.UUID;

public abstract class Pessoa {
    private String id;
    private String nome;

    public Pessoa(String nome) {
        setId(UUID.randomUUID().toString());
        setNome(nome);
    }

    @Override
    public String toString() {
        return "Pessoa{ id= " + id + ", nome= " + nome + "}";
        //Pessoa{ id= 1, nome= Nome }
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
}
