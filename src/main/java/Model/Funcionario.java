package Model;

public class Funcionario extends Pessoa {
    private String funcao;

    public Funcionario(String nome, String funcao) {
        super(nome);
        setFuncao(funcao);
    }

    @Override
    public String toString() {
        return super.toString() + " Funcionario{" + "funcao=" + funcao + '}';
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
