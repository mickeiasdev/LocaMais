package Model;

public class Cliente extends Pessoa {
    private String cnh;

    public Cliente(String nome, String cnh) {
        super(nome);
        setCnh(cnh);
    }

    @Override
    public String toString() {
        return super.toString() + " Cliente{" + "cnh=" + cnh + '}';
    }

    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
